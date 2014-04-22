package circlebinder.common.app;

import android.support.v4.app.Fragment;

import net.ichigotake.common.view.inputmethod.SoftInput;

/**
 * 全てのフラグメントの基底クラス
 */
abstract public class BaseFragment extends Fragment {

    @Override
    public void onResume() {
        super.onResume();
        SoftInput.hide(getView());
    }
}
