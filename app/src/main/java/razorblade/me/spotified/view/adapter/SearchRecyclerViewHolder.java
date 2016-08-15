package razorblade.me.spotified.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import razorblade.me.spotified.R;

/**
 * Created by alexandre on 14/08/16.
 */
public class SearchRecyclerViewHolder extends RecyclerView.ViewHolder {

    public TextView name;
    public ImageView thumb;

    public SearchRecyclerViewHolder(View itemView) {
        super(itemView);

        name = (TextView) itemView.findViewById(R.id.name);
        thumb = (ImageView) itemView.findViewById(R.id.thumb);
    }
}
