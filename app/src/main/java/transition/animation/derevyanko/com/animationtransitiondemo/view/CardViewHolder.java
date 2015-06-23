package transition.animation.derevyanko.com.animationtransitiondemo.view;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import transition.animation.derevyanko.com.animationtransitiondemo.R;
import transition.animation.derevyanko.com.animationtransitiondemo.activity.DetailActivity;
import transition.animation.derevyanko.com.animationtransitiondemo.adapter.DataProvider;

/**
 * Created by anton on 6/22/15.
 */
public final class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @InjectView(R.id.itemImage)
    ImageView image;
    @InjectView(R.id.itemTitle)
    TextView title;

    private final Context context;
    private int position;

    public CardViewHolder(View itemView) {
        super(itemView);
        ButterKnife.inject(this, itemView);
        this.context = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void setData(int position) {
        this.position = position;
        image.setImageDrawable(context.getResources().getDrawable(DataProvider.getImageIdByPosition(position)));
        title.setText(DataProvider.getTitleByPosition(context, position));
    }

    @Override
    public void onClick(View v) {
        Context context = v.getContext();

        Intent intent = new Intent(v.getContext(), DetailActivity.class);
        intent.putExtra(DetailActivity.KEY_IMAGE_NUMBER, position);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) context,
                    Pair.create((View) image, image.getTransitionName()));
            context.startActivity(intent, options.toBundle());
        } else {
            context.startActivity(intent);
        }
    }
}
