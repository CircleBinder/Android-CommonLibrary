package net.ichigotake.circlebinder.common.search;

import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import net.ichigotake.common.view.inputmethod.SoftInput;

final class OnEditorActionListenerImpl implements TextView.OnEditorActionListener {

    private final OnSearchActionListener listener;
    private final CircleSearchOptionContainer container;

    OnEditorActionListenerImpl(OnSearchActionListener listener,
                               CircleSearchOptionContainer container) {
        this.listener = listener;
        this.container = container;
    }

    @Override
    public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
        boolean pressEnter = (actionId == EditorInfo.IME_ACTION_SEARCH);
        listener.onSearch(container.getSearchOption());
        if (pressEnter) {
            SoftInput.hide(view);
            listener.onSearch(container.getSearchOption());
        }
        return true;
    }
}
