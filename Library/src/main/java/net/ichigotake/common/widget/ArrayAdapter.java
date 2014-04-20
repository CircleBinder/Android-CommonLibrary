package net.ichigotake.common.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ArrayAdapter<I, T> extends android.widget.ArrayAdapter<I> {

    private final ViewBinder<I, T> binder;
    private final LayoutInflater inflater;

    public ArrayAdapter(Context context, ViewBinder<I, T> binder) {
        super(context, 0);
        this.binder = binder;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        final T tag;
        final I item = getItem(position);
        if (convertView == null) {
            convertView = binder.generateView(position, item, inflater, parent);
            tag = binder.generateTag(position, item, convertView);
            convertView.setTag(tag);
        } else {
            tag = (T)convertView.getTag();
        }

        binder.bindView(position, item, tag);

        return convertView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final T tag;
        final I item = getItem(position);

        if (convertView == null) {
            convertView = binder.generateView(position, item, inflater, parent);
            tag = binder.generateTag(position, item, convertView);
            convertView.setTag(tag);
        } else {
            tag = (T)convertView.getTag();
        }

        binder.bindView(position, item, tag);

        return convertView;
    }

}
