import json

class TrendingOutput:

    def __init__(self):
        self.output = {}

    def add(self, trendingObject):
        self.output[trendingObject.link] = trendingObject

    def toJSON(self):
        return json.dumps(self.__dict__)

class TrendingObject:

    def __init__(self, title = None, author = None, link = None):

        self.title = title        # number
        self.author = author    # number (minute)
        self.link = link        # number


class TrendingInput:

    def __init__(self, timeline, num):

        self.timeline = timeline
        self.num = num
