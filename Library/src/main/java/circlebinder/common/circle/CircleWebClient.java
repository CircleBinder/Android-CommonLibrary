package circlebinder.common.circle;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public final class CircleWebClient extends WebViewClient {

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return false;
    }

}
