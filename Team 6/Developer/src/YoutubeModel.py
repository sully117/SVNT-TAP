from keras.models import load_model


# model handles all Youtube Prediction logic
# Uploads the model from .h5 file and loads it as a keras object
# User information can be passed using the controller
class YoutubeModel(object):
    # TODO: Link up to a model
    # TODO: finish output
    def __init__(self):
        self.mvc_model = self.set_up_model()
        self.output = ""
        self.set_up_model()

    # Load model from file
    # Change from a hardcoded file name dependency injection
    def set_up_model(self):
        return load_model('views_predict.h5')

    # Run Model to obtain prediction
    def runModel(self, user_text):
        self.output = self.mvc_model.predict(user_text)

    # return Output
    def returnOutput(self):
        return self.output
