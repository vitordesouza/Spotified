package razorblade.me.spotified.rest;

import android.content.Context;


import razorblade.me.spotified.domain.SpotifyItem;
import razorblade.me.spotified.domain.resultset.SpotifyArtistResultSet;
import razorblade.me.spotified.rest.exception.HttpRestException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by alexandre on 14/08/16.
 */
public class SearchRestService extends AbstractRestService {
    private Context mContext;

    public SearchRestService(Context mContext) {
        super(mContext);
        this.mContext = mContext;

    }

    public void getArtists(final AbstractRestService.OnResponse<SpotifyArtistResultSet> callback, String query, SpotifyItem type) {
        SearchService searchService = (SearchService) initializeRestService(SearchService.class);
        final Call<SpotifyArtistResultSet> call;
        call = searchService.get(query, type.getType());

        call.enqueue(new Callback<SpotifyArtistResultSet>() {
            @Override
            public void onResponse(Call<SpotifyArtistResultSet> call, Response<SpotifyArtistResultSet> response) {
                callback.success(response.body());
            }

            @Override
            public void onFailure(Call<SpotifyArtistResultSet> call, Throwable t) {
                callback.error((HttpRestException) t);
            }
        });
    }
}
