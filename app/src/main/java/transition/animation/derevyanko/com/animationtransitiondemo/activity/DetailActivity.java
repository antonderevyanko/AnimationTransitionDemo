package transition.animation.derevyanko.com.animationtransitiondemo.activity;

import android.os.Build;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.InjectView;
import transition.animation.derevyanko.com.animationtransitiondemo.BaseActivity;
import transition.animation.derevyanko.com.animationtransitiondemo.R;
import transition.animation.derevyanko.com.animationtransitiondemo.adapter.DataProvider;

public class DetailActivity extends BaseActivity {

    public static final String KEY_IMAGE_NUMBER = "image_number";
    private static final int DELAY_MILLIS = 500;

    @InjectView(R.id.itemImage)
    ImageView image;
    @InjectView(R.id.itemTitle)
    TextView title;
    @InjectView(R.id.itemText)
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide transition = new Slide();
            transition.setStartDelay(DELAY_MILLIS);
            transition.setDuration(DELAY_MILLIS);
            transition.setInterpolator(new DecelerateInterpolator());
            getWindow().setEnterTransition(transition);
            Slide slideDown = new Slide(Gravity.BOTTOM);
            slideDown.setDuration(150);
            getWindow().setReturnTransition(slideDown);
        }

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Postpone the transition until the window's decor view has
            // finished its layout.
            postponeEnterTransition();

            final View decor = getWindow().getDecorView();
            decor.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                @Override
                public boolean onPreDraw() {
                    decor.getViewTreeObserver().removeOnPreDrawListener(this);
                    if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        startPostponedEnterTransition();
                    }
                    return true;
                }
            });
        }

        int position = getIntent().getIntExtra(KEY_IMAGE_NUMBER, 1);
        image.setImageDrawable(getResources().getDrawable(DataProvider.getImageIdByPosition(position)));

        title.setText(DataProvider.getTitleByPosition(this, position));
        text.setText(DataProvider.getTextByPosition(position));

    }
}
