package net.ichigotake.common.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CursorAdapter<I, T> extends android.support.v4.widget.CursorAdapter {

    public static interface CursorCreator<I> {

        I create(Cursor cursor);
    }

    private final CursorAdapterParameter<I, T> parameter;
    private final LayoutInflater inflater;

    public CursorAdapter(CursorAdapterParameter<I, T> parameter) {
        super(parameter.getContext(), parameter.getCursor(), false);
        this.inflater = LayoutInflater.from(parameter.getContext());
        this.parameter = parameter;
    }

    protected CursorAdapterParameter<I, T> getParameter() {
        return parameter;
    }

    @Override
    public I getItem(int position) {
        Cursor cursor = (Cursor)super.getItem(position);
        return cursor != null ? parameter.getCursorCreator().create(cursor) : null;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        int position = cursor.getPosition();
        I item = parameter.getCursorCreator().create(cursor);
        View newView = parameter.getViewBinder().generateView(position, item, inflater, parent);
        newView.setTag(parameter.getViewBinder().generateTag(position, item, newView));
        return newView;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        T tag = (T)view.getTag();
        I item = parameter.getCursorCreator().create(cursor);
        int position = cursor.getPosition();
        parameter.getViewBinder().bindView(position, item, tag);
    }

}
