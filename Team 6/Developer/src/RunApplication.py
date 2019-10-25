import YoutubeModel
import YoutubeController

# EntryPoint for Youtube Prediction Model
# Instantiates the YoutubeModel and the YoutubeController
if __name__ == "__main__":
    YTmodel = YouTubeModel()
    YTController = YoutubeController(YTmodel)
