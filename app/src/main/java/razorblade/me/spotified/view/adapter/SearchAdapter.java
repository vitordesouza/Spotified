package razorblade.me.spotified.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import razorblade.me.spotified.R;
import razorblade.me.spotified.domain.Artist;
import razorblade.me.spotified.domain.SpotifyModel;

/**
 * Created by alexandre on 14/08/16.
 */
public class SearchAdapter extends RecyclerView.Adapter<SearchRecyclerViewHolder>{
    private SpotifyModel[]  items;
    private Context mContext;

    public SearchAdapter(SpotifyModel[] items, Context mContext) {
        this.items = items;
        this.mContext = mContext;
    }

    @Override
    public SearchRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_spotify, null);
        SearchRecyclerViewHolder rcv = new SearchRecyclerViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(SearchRecyclerViewHolder holder, int position) {
        final SpotifyModel item = items[position];
        holder.name.setText(item.getName());
        Glide.with(mContext)
                .load(item.getThumbUrl())
                .into(holder.thumb);

        holder.thumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.length;
    }
}
