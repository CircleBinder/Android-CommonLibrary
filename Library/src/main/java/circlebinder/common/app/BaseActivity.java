package circlebinder.common.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

import net.ichigotake.common.os.RestoreBundle;

/**
 * 全てのアクティビティの基底クラス
 */
public abstract class BaseActivity extends ActionBarActivity {

    private RestoreBundle restoreBundle;

    protected RestoreBundle getRestoreBundle(Bundle savedInstanceState) {
        if (restoreBundle == null) {
            restoreBundle = new RestoreBundle(getIntent(), savedInstanceState);
        }
        return restoreBundle;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
