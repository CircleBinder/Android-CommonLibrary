package circlebinder.common.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import net.ichigotake.common.os.RestoreBundle;
import net.ichigotake.common.view.inputmethod.SoftInput;

/**
 * 全てのフラグメントの基底クラス
 */
abstract public class BaseFragment extends Fragment {

    private RestoreBundle restoreBundle;

    protected RestoreBundle getRestoreBundle(Bundle savedInstanceState) {
        if (restoreBundle == null) {
            restoreBundle = new RestoreBundle(this, savedInstanceState);
        }
        return restoreBundle;
    }

    @Override
    public void onResume() {
        super.onResume();
        SoftInput.hide(getView());
    }
}
