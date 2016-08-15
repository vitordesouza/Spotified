package razorblade.me.spotified.domain.resultset;

import com.google.gson.annotations.SerializedName;

import razorblade.me.spotified.domain.Artist;

/**
 * Created by alexandre on 14/08/16.
 */
public class SpotifyArtistResultSet {
    @SerializedName(value = "artists")
    private SpotifyArtistResultModel model;


    public Artist[] getItems() {
        return model.getItems();
    }

    private class SpotifyArtistResultModel {
        private Artist[] items;

        public Artist[] getItems() {
            return items;
        }
    }
}
