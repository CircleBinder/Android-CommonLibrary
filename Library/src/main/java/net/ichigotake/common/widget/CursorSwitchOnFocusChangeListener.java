package net.ichigotake.common.widget;

import android.view.View;
import android.widget.EditText;

public final class CursorSwitchOnFocusChangeListener implements View.OnFocusChangeListener {

    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        ((EditText) view).setCursorVisible(hasFocus);
    }
}
