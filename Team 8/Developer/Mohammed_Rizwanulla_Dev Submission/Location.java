import java.util.List;

/**
 * Created by ritzbitz on 10/25/19. Template
 */
public class Location {
    float locationID;
    List<Video> videos;

    public Location(float ID) {
        locationID = ID;
        videos = getVidoes(locationID);
    }

    List<Video> getVidoes(float ID) {
        // method extracts all video data from that location given the ID

        return null;
    }

}
