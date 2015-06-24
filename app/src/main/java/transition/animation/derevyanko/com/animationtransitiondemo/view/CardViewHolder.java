package transition.animation.derevyanko.com.animationtransitiondemo.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import transition.animation.derevyanko.com.animationtransitiondemo.R;
import transition.animation.derevyanko.com.animationtransitiondemo.activity.DetailActivity;
import transition.animation.derevyanko.com.animationtransitiondemo.adapter.DataProvider;

import java.util.ArrayList;
import java.util.List;

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

        Activity activity = (Activity) context;
        View statusBar = activity.findViewById(android.R.id.statusBarBackground);
        View navigationBar = activity.findViewById(android.R.id.navigationBarBackground);
        // todo handle action bar

        List<Pair<View, String>> pairs = new ArrayList<>();
        pairs.add(Pair.create(statusBar, Window.STATUS_BAR_BACKGROUND_TRANSITION_NAME));
        if (navigationBar != null) {
            pairs.add(Pair.create(navigationBar, Window.NAVIGATION_BAR_BACKGROUND_TRANSITION_NAME));
        }
        pairs.add(Pair.create((View) image, ViewCompat.getTransitionName(image)));

        Bundle options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity,
                pairs.toArray(new Pair[pairs.size()])).toBundle();
        activity.startActivity(intent, options);
    }
}
