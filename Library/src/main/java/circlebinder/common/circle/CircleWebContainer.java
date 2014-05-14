package circlebinder.common.circle;

import android.os.Build;
import android.webkit.WebView;

public final class CircleWebContainer {

    private final WebView webView;

    public CircleWebContainer(WebView webView) {
        this.webView = webView;
    }

    public void initialize() {
        webView.setWebViewClient(new CircleWebClient(webView));
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setBuiltInZoomControls(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            webView.getSettings().setJavaScriptEnabled(true);
        } else {
            webView.getSettings().setJavaScriptEnabled(false);
        }
        webView.setOnKeyListener(new CircleWebOnKeyListener(webView));
    }

    public void loadUrl(String url) {
        webView.loadUrl(url);
    }

    public String getCurrentUrl() {
        return webView.getUrl();
    }
}
