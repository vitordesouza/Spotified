package razorblade.me.spotified.rest;

import razorblade.me.spotified.domain.resultset.SpotifyArtistResultSet;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.Call;

/**
 * Created by alexandre on 14/08/16.
 */
public interface SearchService {
    @GET("search")
    Call<SpotifyArtistResultSet> get(@Query("q") String query, @Query("type") String type);
}
