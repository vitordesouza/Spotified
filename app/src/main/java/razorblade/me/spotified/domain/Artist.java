package razorblade.me.spotified.domain;

import java.util.List;

/**
 * Created by alexandre on 14/08/16.
 */
public class Artist implements SpotifyModel {
    String name;
    List<SpotifyThumb> images;
    String id;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getThumbUrl() {
        if (images.size() == 0)
            return "https://assets.entrepreneur.com/content/16x9/822/20150616163611-spotify.jpeg";

        return images.get(0).getUrl();
    }

    @Override
    public String getId() {
        return id;
    }
}
