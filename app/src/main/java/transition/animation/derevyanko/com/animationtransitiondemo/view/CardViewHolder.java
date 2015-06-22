package transition.animation.derevyanko.com.animationtransitiondemo.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.ButterKnife;

/**
 * Created by anton on 6/22/15.
 */
public final class CardViewHolder extends RecyclerView.ViewHolder {

    private final Context context;

    public CardViewHolder(View itemView) {
        super(itemView);
        ButterKnife.inject(this, itemView);
        this.context = itemView.getContext();
    }
}
