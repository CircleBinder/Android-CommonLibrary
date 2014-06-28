package net.ichigotake.common.app;

import android.support.v4.view.ViewPager;

public final class FragmentOnPageChangeListener implements ViewPager.OnPageChangeListener {

    private final FragmentPagerAdapter adapter;
    private int lastPosition;

    public FragmentOnPageChangeListener(FragmentPagerAdapter adapter, int offsetPosition) {
        this.adapter = adapter;
        this.lastPosition = offsetPosition;
    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        adapter.callOnInactive(lastPosition);
        this.lastPosition = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
