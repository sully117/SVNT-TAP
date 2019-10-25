# import RecommendInput
# import RecommendOutput

from recommend_data_schema import RecommendOutput

class Model:
    def predict(self, recommendInput):
        # give the input to the model
        # and get output from the model
        fake_data = {
            "view" : 10001,
            "duration": 12,
            "like": 1221
        }
        output = RecommendOutput(fake_data.get("view"), fake_data.get("duration"), fake_data.get("like"))  # fake output for now

        return output
