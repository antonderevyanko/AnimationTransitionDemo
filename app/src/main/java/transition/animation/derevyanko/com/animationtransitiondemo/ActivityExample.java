package transition.animation.derevyanko.com.animationtransitiondemo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import butterknife.InjectView;
import transition.animation.derevyanko.com.animationtransitiondemo.adapter.CardsAdapter;
import transition.animation.derevyanko.com.animationtransitiondemo.adapter.DataProvider;

public class ActivityExample extends BaseActivity {

    @InjectView(R.id.recyclerList)
    RecyclerView recyclerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_example);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerList.setLayoutManager(layoutManager);
        recyclerList.setAdapter(new CardsAdapter(DataProvider.getDataSize()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_example, menu);
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
