package circlebinder.common.app;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;

import net.ichigotake.common.view.inputmethod.SoftInput;

/**
 * 全てのフラグメントの基底クラス
 */
abstract public class BaseFragment extends Fragment {

    protected ActionBarActivity getSupportActivity() {
        return (ActionBarActivity)getActivity();
    }

    @Override
    public void onResume() {
        super.onResume();
        SoftInput.hide(getView());
    }
}
