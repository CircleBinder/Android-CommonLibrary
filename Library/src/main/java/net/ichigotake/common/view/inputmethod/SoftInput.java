package net.ichigotake.common.view.inputmethod;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public final class SoftInput {

    public static void hide(View targetView) {
        Context context = targetView.getContext();
        if (context == null) {
            return ;
        }

        InputMethodManager inputMethodManager = (InputMethodManager)context.getSystemService(
                Context.INPUT_METHOD_SERVICE
        );

        if (inputMethodManager == null) {
            return ;
        }

        inputMethodManager.hideSoftInputFromWindow(
                targetView.getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS
        );
    }
}
