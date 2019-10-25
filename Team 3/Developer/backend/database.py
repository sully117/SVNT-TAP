import mysql.connector

class MySQL:

    def __init__(self):
        self.mydb = mysql.connector.connect(
            host="localhost",
            user="yourusername",
            passwd="yourpassword"
        )

        self.my_cursor = self.mydb.cursor()

    def get_user_history(self, user_id):

        '''
        Should prevent SQL Injection in the future work!!!!
        :param user_id:
        :return:
        '''
        sql_command = "SELECT * FROM history where user_id = " + user_id

        self.mycursor.execute(sql_command)

        result = self.my_cursor.fetchall()

        return result
