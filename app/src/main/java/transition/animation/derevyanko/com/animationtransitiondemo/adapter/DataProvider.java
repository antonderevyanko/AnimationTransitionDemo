package transition.animation.derevyanko.com.animationtransitiondemo.adapter;

import android.content.Context;
import com.thedeanda.lorem.Lorem;
import transition.animation.derevyanko.com.animationtransitiondemo.R;
import transition.animation.derevyanko.com.animationtransitiondemo.exception.NoResourceException;

/**
 * Created by anton on 6/22/15.
 */
public final class DataProvider {

    private static final int[] IMAGE_RESOURCES = {R.drawable.img_1, R.drawable.img_2, R.drawable.img_3,
            R.drawable.img_4, R.drawable.img_5, R.drawable.img_6, R.drawable.img_7, R.drawable.img_8,
            R.drawable.img_9, R.drawable.img_10, R.drawable.img_11, R.drawable.img_12, R.drawable.img_13,
            R.drawable.img_14, R.drawable.img_15, R.drawable.img_16, R.drawable.img_17};

    public static int getDataSize() {
        return IMAGE_RESOURCES.length;
    }

    public static int getImageIdByPosition(int position) throws NoResourceException {
        if (position <= IMAGE_RESOURCES.length) {
            return IMAGE_RESOURCES[position];
        } else {
            throw new NoResourceException(position);
        }
    }

    public static String getTitleByPosition(Context context, int position) {
        return context.getResources().getString(R.string.title, position + 1);
    }

    public static String getTextByPosition(int position) {
        return Lorem.getParagraphs(2, 5);
    }
}
