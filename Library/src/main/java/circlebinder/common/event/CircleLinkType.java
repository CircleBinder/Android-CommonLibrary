package circlebinder.common.event;

import circlebinder.common.R;

public enum CircleLinkType {

    PIXIV(R.string.circlebinder_circle_link_pixiv, R.id.circlebinder_menu_circle_links_pixiv),
    HOMEPAGE(R.string.circlebinder_circle_link_homepage, R.id.circlebinder_menu_circle_links_homepage),
    ;

    private final int name;
    private final int menuItemId;

    private CircleLinkType(int name, int menuItemId) {
        this.name = name;
        this.menuItemId = menuItemId;
    }

    public int getMenuItemId() {
        return menuItemId;
    }

    public int getNameResource() {
        return name;
    }

}
