package net.ichigotake.common.app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

public class FragmentPagerAdapter extends FragmentStatePagerAdapter {

    private final FragmentPagerItem item;
    private final SparseArray<Object> registeredPages;

    public FragmentPagerAdapter(FragmentManager fm, FragmentPagerItem item) {
        super(fm);
        this.item = item;
        this.registeredPages = new SparseArray<Object>();
    }

    public void reload() {
        for (int i=0, size=item.getCount(); i<size; i++) {
            reload(i);
        }
    }

    public void reload(int position) {
        Object page = registeredPages.get(position);
        if (page != null && page instanceof Pane) {
            ((Pane)page).tap();
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object fragment = super.instantiateItem(container, position);
        registeredPages.put(position, fragment);
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        registeredPages.remove(position);
        super.destroyItem(container, position, object);
    }

    @Override
    public int getItemPosition(Object fragment) {
        return POSITION_NONE;
    }

    @Override
    public Fragment getItem(int position) {
        return item.getItem(position % getCount());
    }

    @Override
    public int getCount() {
        return item.getCount();
    }

    @Override
    public CharSequence getPageTitle(int location) {
        return item.getPageTitle(location);
    }

}
