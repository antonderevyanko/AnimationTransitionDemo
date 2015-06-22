package transition.animation.derevyanko.com.animationtransitiondemo.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import transition.animation.derevyanko.com.animationtransitiondemo.R;
import transition.animation.derevyanko.com.animationtransitiondemo.adapter.DataProvider;

/**
 * Created by anton on 6/22/15.
 */
public final class CardViewHolder extends RecyclerView.ViewHolder {

    @InjectView(R.id.itemImage)
    ImageView image;
    @InjectView(R.id.itemTitle)
    TextView title;

    private final Context context;

    public CardViewHolder(View itemView) {
        super(itemView);
        ButterKnife.inject(this, itemView);
        this.context = itemView.getContext();
    }

    public void setData(int position) {
        image.setImageDrawable(context.getResources().getDrawable(DataProvider.getImageIdByPosition(position)));
        title.setText(DataProvider.getTitleByPosition(context, position));
    }
}
