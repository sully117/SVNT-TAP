
######
# The interface that we communicate with data science model
######

import json

class RecommendOutput:

    def __init__(self, view = None, duration = None, like = None):
        self.view = view        # number
        self.duration = duration    # number (minute)
        self.like = like        # number

    def toJSON(self):
        return json.dumps(self.__dict__)

class RecommendInput:

    def __init__(self, country = None, topic = None, title = None, publish_time = None, tag = None):
        self.country = country
        self.topic = topic
        self.title = title
        self.publish_time = publish_time
        self.tag = tag