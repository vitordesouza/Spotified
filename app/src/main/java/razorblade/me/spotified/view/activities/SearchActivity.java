package razorblade.me.spotified.view.activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import razorblade.me.spotified.R;
import razorblade.me.spotified.domain.SpotifyItem;
import razorblade.me.spotified.domain.SpotifyModel;
import razorblade.me.spotified.domain.resultset.SpotifyArtistResultSet;
import razorblade.me.spotified.rest.AbstractRestService;
import razorblade.me.spotified.rest.SearchRestService;
import razorblade.me.spotified.rest.exception.HttpRestException;
import razorblade.me.spotified.view.adapter.SearchAdapter;

public class SearchActivity extends AppCompatActivity {

    private GridLayoutManager lLayout;
    private RecyclerView rView;
    private EditText search;
    private Button btn;
    private String term;

    private SearchRestService searchRestService;



    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setTitle(null);

        searchRestService = new SearchRestService(this);

        Toolbar topToolBar = (Toolbar) findViewById(R.id.toolbarCategory);
        setSupportActionBar(topToolBar);

        search = (EditText) findViewById(R.id.searchTerm);
        btn = (Button) findViewById(R.id.search_btn);


        lLayout = new GridLayoutManager(SearchActivity.this, 2);

        rView = (RecyclerView) findViewById(R.id.recycler_item);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                term = search.getText().toString();

                retrieveData(term);
            }
        });
    }

    private void retrieveData(String term) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle(getString(R.string.progress_title_artist_search));
        progressDialog.setMessage(getString(R.string.progress_message_artist_search));
        progressDialog.show();
        searchRestService.getArtists(new AbstractRestService.OnResponse<SpotifyArtistResultSet>() {
            @Override
            public void success(SpotifyArtistResultSet spotifyModels) {
                refreshAdapter(spotifyModels.getItems());
                progressDialog.hide();
            }

            @Override
            public void error(HttpRestException restException) {
                progressDialog.hide();
            }
        }, term, SpotifyItem.ARTIST);
    }

    private void refreshAdapter(SpotifyModel[] spotifyModels) {
        SearchAdapter rcAdapter = new SearchAdapter(spotifyModels, this);
        rView.setAdapter(rcAdapter);
    }
}
