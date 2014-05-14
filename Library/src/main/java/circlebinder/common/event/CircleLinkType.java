package circlebinder.common.event;

import circlebinder.common.R;

public enum CircleLinkType {

    PIXIV("pixiv", R.id.circlebinder_menu_circle_links_pixiv),
    HOMEPAGE("ホームページ", R.id.circlebinder_menu_circle_links_homepage),
    ;

    private final String name;
    private final int menuItemId;

    private CircleLinkType(String name, int menuItemId) {
        this.name = name;
        this.menuItemId = menuItemId;
    }

    public int getMenuItemId() {
        return menuItemId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}
