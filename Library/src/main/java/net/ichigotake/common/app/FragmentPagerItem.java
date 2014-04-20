package net.ichigotake.common.app;

import android.support.v4.app.Fragment;

public final class FragmentPagerItem<FRAGMENT extends Fragment> {

    private final CharSequence pagerTitle;
    private final FragmentFactory<FRAGMENT> fragmentFactory;

    public FragmentPagerItem(CharSequence pagerTitle, FragmentFactory<FRAGMENT> fragmentFactory) {
        this.pagerTitle = pagerTitle;
        this.fragmentFactory = fragmentFactory;
    }

    public CharSequence getPageTitle() {
        return pagerTitle;
    }

    public FragmentFactory<FRAGMENT> getFactory() {
        return fragmentFactory;
    }

}
