package transition.animation.derevyanko.com.animationtransitiondemo;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import butterknife.ButterKnife;

/**
 * Created by anton on 6/21/15.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void setContentView(View view) {
        ButterKnife.reset(this);
        super.setContentView(view);
        ButterKnife.inject(this);
    }

    @Override
    public void setContentView(int layoutResID) {
        ButterKnife.reset(this);
        super.setContentView(layoutResID);
        ButterKnife.inject(this);
    }
}
