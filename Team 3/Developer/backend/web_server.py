from tornado.web import Application
from tornado.web import RequestHandler
from tornado.ioloop import IOLoop

from recommend_engine import RecommendEngine
from trending_engine import TrendingEngine

class RecommendHandler(RequestHandler):
    def get(self):
        country = self.get_argument('country', default=None)
        topic = self.get_argument('topic', default=None)

        # init engine
        engine = RecommendEngine()

        # get recommend output (JSON)
        recommendOutput = engine.recommend(country=country, topic=topic)

        self.write(recommendOutput)

class TrendingHandler(RequestHandler):
    def get(self):

        timeline = self.get_argument('timeline', default=None)
        if timeline == None:
            timeline = 7    # means 7 days
        num = self.get_argument('num', default=None)
        if num == None:
            num = 10        # means 10 top trending

        # init engine
        engine = TrendingEngine()

        # get trending output (JSON)
        output = engine.getTrends(timeline=timeline, num=num)

        self.write(output)

class AdvanceRecommendHandler(RequestHandler):

    def get(self):

        # 1. get user history
        # 2. provide the link of the video to upload
        # 3. return advanced recommendation
        self.write("Advance recommendation is coming! Please have a wait :)")


if __name__ == "__main__":
    handler_mapping = [
        (r'/recommend', RecommendHandler),
        (r'/trending', TrendingHandler),
        (r'/advanced_recommend', AdvanceRecommendHandler)
    ]
    application = Application(handler_mapping)
    application.listen(7777)
    IOLoop.current().start()