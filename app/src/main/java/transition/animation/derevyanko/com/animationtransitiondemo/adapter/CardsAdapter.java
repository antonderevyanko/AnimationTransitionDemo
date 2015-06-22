package transition.animation.derevyanko.com.animationtransitiondemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import transition.animation.derevyanko.com.animationtransitiondemo.R;
import transition.animation.derevyanko.com.animationtransitiondemo.view.CardViewHolder;

/**
 * Created by anton on 6/22/15.
 */
public final class CardsAdapter extends RecyclerView.Adapter<CardViewHolder> {

    private int size;

    public CardsAdapter(int size) {
        this.size = size;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_view, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CardViewHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return size;
    }
}
