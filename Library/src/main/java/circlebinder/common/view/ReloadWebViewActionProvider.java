package circlebinder.common.view;

import android.content.Context;
import android.net.Uri;
import android.view.ActionProvider;
import android.view.View;

import circlebinder.common.circle.CircleWebContainer;

public final class ReloadWebViewActionProvider extends ActionProvider {

    private final Uri uri;
    private final CircleWebContainer webContainer;

    public ReloadWebViewActionProvider(Context context, CircleWebContainer webContainer, Uri uri) {
        super(context);
        this.uri = uri;
        this.webContainer = webContainer;
    }

    @Override
    public View onCreateActionView() {
        return null;
    }

    @Override
    public boolean onPerformDefaultAction() {
        webContainer.loadUrl(uri.toString());
        return super.onPerformDefaultAction();
    }

}
