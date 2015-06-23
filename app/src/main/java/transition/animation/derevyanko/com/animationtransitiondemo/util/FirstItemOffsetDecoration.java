package transition.animation.derevyanko.com.animationtransitiondemo.util;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by anton on 6/23/15.
 */
public final class FirstItemOffsetDecoration extends RecyclerView.ItemDecoration {

    private static final int OFFSET_IN_DP = 10;

    private final int offset;

    public FirstItemOffsetDecoration(Context context) {
        this(context, OFFSET_IN_DP);
    }

    public FirstItemOffsetDecoration(Context context, int offsetInDp) {
        offset = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                offsetInDp,
                context.getResources().getDisplayMetrics());
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (parent.getChildPosition(view) == 0) {
            outRect.set(0, offset, 0, 0);
        }
    }
}
