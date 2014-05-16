package net.ichigotake.common.app;

import android.support.v4.app.Fragment;

public interface FragmentPagerItem {

    Fragment getItem(int position);

    CharSequence getPageTitle(int position);

    int getCount();

}
