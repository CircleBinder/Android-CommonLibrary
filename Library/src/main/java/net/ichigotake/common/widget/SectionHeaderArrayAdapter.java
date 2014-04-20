package net.ichigotake.common.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public class SectionHeaderArrayAdapter<ITEM, ITEM_TAG, HEADER_TAG> extends ArrayAdapter<ITEM, ITEM_TAG>
        implements SectionHeaderAdapter {

    private final SectionHeaderBinder<ITEM, ITEM_TAG, HEADER_TAG> binder;

    public SectionHeaderArrayAdapter(Context context, SectionHeaderBinder<ITEM, ITEM_TAG, HEADER_TAG> binder) {
        super(context, binder);
        this.binder = binder;
    }


    @Override
    public View getHeaderView(int position, View view, ViewGroup viewGroup) {
        HEADER_TAG tag;
        ITEM item = getItem(position);
        if (view == null) {
            view = binder.generateHeaderView(position, item, inflater);
            tag = binder.generateHeaderTag(position, item, view);
            view.setTag(tag);
        } else {
            tag = (HEADER_TAG)view.getTag();
        }

        binder.bindHeaderView(position, item, tag);

        return view;
    }

    @Override
    public long getHeaderId(int position) {
        return binder.getHeaderId(position, getItem(position));
    }

}
