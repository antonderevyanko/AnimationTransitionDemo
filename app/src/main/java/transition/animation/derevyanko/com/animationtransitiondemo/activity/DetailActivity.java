package transition.animation.derevyanko.com.animationtransitiondemo.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import butterknife.InjectView;
import transition.animation.derevyanko.com.animationtransitiondemo.BaseActivity;
import transition.animation.derevyanko.com.animationtransitiondemo.R;
import transition.animation.derevyanko.com.animationtransitiondemo.adapter.DataProvider;

public class DetailActivity extends BaseActivity {

    public static final String KEY_IMAGE_NUMBER = "image_number";

    @InjectView(R.id.itemImage)
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        int positionInList = getIntent().getIntExtra(KEY_IMAGE_NUMBER, 1);
        image.setImageDrawable(getResources().getDrawable(DataProvider.getImageIdByPosition(positionInList)));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
