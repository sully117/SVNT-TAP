import java.util.ArrayList;
import java.util.List;

/**
 * Created by ritzbitz on 10/25/19. Template
 */
public class User {

    public double predictViews(float categoryID, float locationID) {
        Location location = new Location(locationID);
        List<Video> videos = getVideos(categoryID, location);

        // make the prediction

            /*
            average the views given a category
            - i.e. music videos avg 2 million views
            average the subscribers for every music video
            - i.e each channel has about 200k subscribers
             */

        // since predicitons are based on the same data, check if the same parameters have
        // already been checked
        double inHistory = checkHistory(categoryID, locationID);
        if (inHistory > 0) return inHistory;

        // assuming that these are the 2 most important values being used in the prediction model
        double viewAverage = getAverageViews(videos);
        double subcribersAverage = getAverageSubscribers(videos);


        // call a function that uses the information in that area
        return makePrediciton(viewAverage, subcribersAverage);
    }

    /* drawbacks:
        - the location object might be significantly bigger than is good
        - might be a quicker way just to get the relavant information from the locationID and categoryID
   */
    List<Video> getVideos(float categoryID, Location location) {
        // method gets all videos with the given idea given the location object

        List<Video> ret = new ArrayList<>();

        for (Video v : location.videos) {
            if (v.categoryID == categoryID) ret.add(v);
        }

        return ret;
    }

    double checkHistory(float categoryID, float locationID) {
        /*
        hypothetically the history should be stored in the database and should be calling a function here.
        When the function is called, the list is populated with the information.
         */
        List<History> history = new ArrayList<>();

        for (History h : history) {
            if (h.categoryID == categoryID && h.locationID == locationID) return h.predictedViews;
        }

        return -1;
    }

    void linearRegressionModel(List<Video> videos) {
        // simple equation
        /*
        y' = a + bx

       using 2 values. num of subscribers and num of views

       y = views
       x = subscribers
         */

        // find a
        double sumY = getSum(videos, 1);
        double sumX = getSum(videos, 2);

        double xySum = getSum(videos, 3);
        double xSquaredSum = getSum(videos, 4);
        double ySquaredSum = getSum(videos, 4);

        double n = videos.size();

        double a = getA(sumY, sumX, xySum, xSquaredSum, n);
        // double b = getB(sumY, sumX, xySum, xSquaredSum);
    }

    double getA(double sumY, double sumX, double xySum, double xSquaredSum, int n) {
        double numerator = (sumY * xSquaredSum) - (sumX * xySum);
        double denominator = (n * xSquaredSum) - Math.pow(sumX, 2);

        return numerator / denominator;
    }

    double getSum(List<Video> videos, int flag) {
        double sum = 0;
        if (flag == 1) {
            for (Video v : videos)
                sum += v.views;
        } else if (flag == 2) {
            for (Video v : videos)
                sum += v.subscribers;
        } else if (flag == 3) {
            for (Video v : videos) {
                sum += (v.views * v.subscribers);
            }
        } else if (flag == 4) {
            for (Video v : videos) {
                sum += v.views * v.views;
            }
        } else if (flag == 5) {
            for (Video v : videos) {
                sum += v.subscribers * v.subscribers;
            }
        }
        return sum;
    }

    /*
    drawbacks:
    - sum might be larger than the value that double can hold

     */
    double getAverageViews(List<Video> videos) {
        double sum = 0;

        for (Video v : videos) {
            sum += (double)v.views;
        }

        return sum / videos.size();
    }

    double getAverageSubscribers(List<Video> videos) {
        double sum = 0;

        for (Video v : videos)
            sum += v.subscribers;

        return sum / videos.size();
    }

    double makePrediciton(double viewAverage, double subscriberAvg) {
        // making a prediction using a linear regression model

        return 0;
    }
}
