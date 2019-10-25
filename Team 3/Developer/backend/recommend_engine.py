from models import Model
from recommend_data_schema import RecommendInput

class RecommendEngine:
    def recommend(self, country, topic):

        # wrap the input
        input = RecommendInput(country = country, topic = topic)

        # initialize model
        model = Model()

        # predict
        output = model.predict(input)

        return output.toJSON()





