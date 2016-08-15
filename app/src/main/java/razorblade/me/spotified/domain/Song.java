package razorblade.me.spotified.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alexandre on 14/08/16.
 */
public class Song implements SpotifyModel{
    private String name;
    private String thumbnail;
    private String id;
    @SerializedName("preview_url")
    private String previewUrl;


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

    public String getPreviewUrl() {
        return previewUrl;
    }
}
