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

    private final ViewBinder<I, T> binder;
    private final LayoutInflater inflater;
    private final CursorCreator<I> creator;

    public CursorAdapter(CursorAdapterParameter<I, T> parameter) {
        this(
                parameter.getContext(),
                parameter.getCursor(),
                parameter.getViewBinder(),
                parameter.getCursorCreator()
        );
    }

    public CursorAdapter(Context context, Cursor c, ViewBinder<I, T> binder, CursorCreator<I> creator) {
        super(context, c, false);
        this.binder = binder;
        this.inflater = LayoutInflater.from(context);
        this.creator = creator;
    }

    @Override
    public I getItem(int position) {
        Cursor cursor = (Cursor)super.getItem(position);
        return cursor != null ? creator.create(cursor) : null;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        int position = cursor.getPosition();
        I item = creator.create(cursor);
        View newView = binder.generateView(position, item, inflater, parent);
        newView.setTag(binder.generateTag(position, item, newView));
        return newView;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        T tag = (T)view.getTag();
        I item = creator.create(cursor);
        int position = cursor.getPosition();
        binder.bindView(position, item, tag);
    }

}
