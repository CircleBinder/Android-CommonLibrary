package net.ichigotake.common.app;

import android.content.Context;
import android.support.v4.view.ActionProvider;
import android.view.View;

public final class ActionSendFilterActionProvider extends ActionProvider {

    private final String url;

    public ActionSendFilterActionProvider(Context context, String url) {
        super(context);
        this.url = url;
    }

    @Override
    public View onCreateActionView() {
        return null;
    }

    @Override
    public boolean onPerformDefaultAction() {
        new ActivityTripper(
                getContext(),
                new ActionSendActivityFactory(url)
        ).trip();
        return super.onPerformDefaultAction();
    }
}
