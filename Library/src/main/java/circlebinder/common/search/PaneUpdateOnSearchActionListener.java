package circlebinder.common.search;

import net.ichigotake.common.app.Pane;

public final class PaneUpdateOnSearchActionListener implements OnSearchActionListener {

    private final Pane pane;

    public PaneUpdateOnSearchActionListener(Pane pane) {
        this.pane = pane;
    }

    @Override
    public void onSearch() {
        pane.tap();
    }

    @Override
    public void onOption() {
        //今はViewも無い
    }

}
