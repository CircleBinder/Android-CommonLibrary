package net.ichigotake.circlebinder.common.search;

import android.view.View;

final class OnOptionClickListener implements View.OnClickListener {

    private final OnSearchActionListener listener;

    OnOptionClickListener(OnSearchActionListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        listener.onOption();
    }
}
