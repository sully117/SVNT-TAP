# Controller: Obtains information from the view
#             Runs that information on the models prediction
#
import YoutubeModel


class YoutubeController:
    # TODO: Connect the controller to the javascript button!
    # Create the youtube Controller
    def __init__(self, the_model):
        self.model = the_model
        self.user_text = ""
        self.user_classification = ""
        # TODO: Finish creating the form the values will take
        self.values = ""

    # passes information from the model
    def obtain_prediction(self):
        self.model.run_model(self.user_text)
        self.values = self.model.returnOutput()

    # Get information from the button
    def buttonListenerGetText(self, user_text):
        self.user_text = user_text

    # sends the information from the view
    def send_output_to_view(self):
        return self.values

