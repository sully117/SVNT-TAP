from sqlalchemy import create_engine
import socket
import io
import sys


class Server:
    def __init__(self, address, controller=None):
        self.listen_socket = socket.socket(family=socket.AF_INET, type=socket.SOCK_STREAM)
        self.listen_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
        self.listen_socket.bind(address)
        self.listen_socket.listen(1)
        host, port = self.listen_socket.getsockname()[:2]
        self.server_name = socket.getfqdn(host)
        self.server_port = port

        # Set Controller
        self.controller = controller

    def serve(self):
        while True:
            client_conn, client_addr = self.listen_socket.accept()
            self.handle(client_conn, client_addr)

    def handle(self, conn, addr):
        request = conn.recv(4096)

        controller_input = self.parse_request(request)

        self.controller.add_task(controller_input.user_id, controller_input.user_input, controller_input.session)
        res = None
        while res is None:
            try:
                res = self.controller.outputs[controller_input.session]
            except KeyError:
                continue

        self.give_response(res, conn, addr)

    def give_response(self, result, conn):
        try:
            response = self.create_response(result)
            conn.sendall(response.encode())
        finally:
            conn.close()

    def create_response(self):
        return # HTTP Response

    def parse_request(self, request):
        return  # conversion of the request to data the controller can process


# Given a certain user, returns the specific model used by the Controller to predict
def get_model_type(user):
    return 'basic'


def sanitize_user_input(user_input):
    return  # sanitized user_input


def combine_input(user, user_input, model_type):
    # logic for combining a user with the user_input depending on model type
    return  # combined input


# Server-side controller that handles requests from client-side Views
class Controller:
    def __init__(self):
        self.models = dict()
        self.tasks = []  # list of (user, input, model_type) pairs to execute
        self.db = create_engine()
        self.users = self.db.Table('users')
        self.outputs = {}

    def get_prediction(self, input, model_type):
        return self.models[model_type].get_prediction(input)

    # returns the combined user input and user data to create the input for the model
    def process_user_input(self, user, user_input, model_type):
        user_input = sanitize_user_input(user_input)
        return combine_input(user, user_input, model_type)  # combined input

    def add_user(self, user):
        query = self.db.insert(user)
        conn = self.db.connect()
        conn.execute(query)

    def add_task(self, user_id, user_input, session):
        query = self.db.select([self.users]).where(self.users.columns.id == user_id)
        conn = self.db.connect()
        user = conn.execute(query)
        model_type = get_model_type(user)
        input = self.process_user_input(user, user_input, model_type)
        self.tasks.append((user, input, model_type, session))

    def add_model(self, model_type, model):
        self.models[model_type] = model

    def process_tasks(self):
        while (len(self.tasks) > 0):
            user, input, model_type, session = self.tasks[0]
            output = self.get_prediction(user, input)
            self.collect_output(output, session)
            self.tasks = self.tasks[1:]

    def collect_output(self, output, session):
        self.outputs[session] = output
        return  # sends a response to the client-side view


# API for Model
class Model:

    # Gets the specific input type that the Model uses
    def get_input_type(self):
        pass

    def get_prediction(self, input):
        pass

    # returns the most common tags collected by the model
    def get_most_common_tags(self):
        return list('fortnite')


class View:
    # Initialize a View that connects to the server-side Controller to send requests
    def __init__(self, connection):
        self.conn = connection

    def display(self):
        pass

    def send_request(self, request):
        pass


class Input:
    # Base Input class which specifies what kind of input a model will take
    def __init__(self, **kwargs):
        self.user = kwargs['user']


class BasicInput(Input):
    def __init__(self, **kwargs):
        Input.__init__(self, kwargs)
        self.tags = kwargs['tags']
        self.publish_time = kwargs['publish_time']
        self.user_size = kwargs['user_size']

    def get_input_type(self):
        return 'BasicInput'
