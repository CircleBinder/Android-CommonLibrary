package circlebinder.common.circle;

import android.os.Build;
import android.webkit.WebView;

import circlebinder.common.event.Circle;
import circlebinder.common.event.CircleLink;

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

    public void loadUrl(CircleLink link) {
        loadUrl(link.getUri().toString());
    }

    public void loadUrl(String url) {
        webView.loadUrl(url);
    }

    public void load(Circle circle) {
        webView.loadUrl(
                "https://google.co.jp/search?q=\"" + circle.getName() + "\""
                        + "%20\"" + circle.getPenName() + "\""
        );
    }

    public String getCurrentUrl() {
        return webView.getUrl();
    }

    public void onDestroy() {
        webView.getSettings().setBuiltInZoomControls(false);
    }
}
