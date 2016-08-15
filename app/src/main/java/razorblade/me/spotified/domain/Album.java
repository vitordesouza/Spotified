package razorblade.me.spotified.domain;

/**
 * Created by alexandre on 14/08/16.
 */
public class Album implements SpotifyModel {
    String name;
    String thumbnail;
    String id;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getThumbUrl() {
        return thumbnail;
    }

    @Override
    public String getId() {
        return id;
    }
}
