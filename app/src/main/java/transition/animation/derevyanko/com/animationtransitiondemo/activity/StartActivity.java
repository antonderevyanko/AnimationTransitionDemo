package transition.animation.derevyanko.com.animationtransitiondemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import butterknife.OnClick;
import transition.animation.derevyanko.com.animationtransitiondemo.BaseActivity;
import transition.animation.derevyanko.com.animationtransitiondemo.R;


public class StartActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.btnStartActivityExample)
    void startActivityExample() {
        startActivity(new Intent(this, ActivityExample.class));
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.btnStartFragmentExample)
    void startFragmentExample() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start, menu);
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
