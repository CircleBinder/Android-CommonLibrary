package net.ichigotake.common.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class SectionHeaderArrayAdapter<ITEM, ITEM_TAG, HEADER_TAG>
        extends ArrayAdapter<ITEM, ITEM_TAG>
        implements SectionHeaderAdapter {

    public SectionHeaderArrayAdapter(Context context) {
        super(context);
    }

    @Override
    public View getHeaderView(int position, View view, ViewGroup viewGroup) {
        HEADER_TAG tag;
        ITEM item = getItem(position);
        if (view == null) {
            view = generateHeaderView(position, item, inflater);
            tag = generateHeaderTag(position, item, view);
            view.setTag(tag);
        } else {
            tag = (HEADER_TAG)view.getTag();
        }

        bindHeaderView(position, item, tag);

        return view;
    }

    @Override
    public long getHeaderId(int position) {
        return getHeaderId(position, getItem(position));
    }

    abstract protected HEADER_TAG generateHeaderTag(int position, ITEM item, View convertView);

    abstract protected View generateHeaderView(int position, ITEM item, LayoutInflater inflater);

    abstract protected void bindHeaderView(int position, ITEM item, HEADER_TAG tag);

    abstract protected long getHeaderId(int position, ITEM item);
}
