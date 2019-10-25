import json

# from trending_data_schema import TrendingOutput, TrendingObject, TrendingInput

class TrendingEngine:
    def getTrends(self, timeline = None, num = None):
        json_output = json.dumps(self.computeTrendingVideo(timeline=timeline, num=num))
        return json_output

    def computeTrendingVideo(self, timeline = None, num = None):

        ########
        #
        #
        # data science work to retrieve the most trending videos
        #
        #
        ########

        fake_data = [{
            "title": "title1",
            "author": "author1",
            "link": "link1"
            },
            {
                "title": "title2",
                "author": "author2",
                "link": "link2"
            },
            {
                "title": "title3",
                "author": "author3",
                "link": "link3"
            }
        ]

        # In future work, I will integrate the trending_data_schema

        return fake_data

