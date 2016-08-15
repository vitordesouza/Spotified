package razorblade.me.spotified.domain;

/**
 * Created by alexandre on 14/08/16.
 */
public enum SpotifyItem {
    ALBUM("album"), ARTIST("artist"), TRACK("track"), PLAYLIST("playlist");
    private String type;

    SpotifyItem(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
