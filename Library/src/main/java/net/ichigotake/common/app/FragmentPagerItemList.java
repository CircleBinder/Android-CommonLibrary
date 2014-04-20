package net.ichigotake.common.app;

import android.support.v4.app.Fragment;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class FragmentPagerItemList {

    private final List<FragmentPagerItem> items;

    public FragmentPagerItemList() {
        items = new CopyOnWriteArrayList<FragmentPagerItem>();
    }

    public int size() {
        return items.size();
    }

    public FragmentPagerItem get(int location) {
        return items.get(location);
    }

    public <FRAGMENT extends Fragment> void add(FragmentPagerItem<FRAGMENT> item) {
        items.add(item);
    }

}
