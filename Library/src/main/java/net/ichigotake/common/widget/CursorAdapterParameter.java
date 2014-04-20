package net.ichigotake.common.widget;

import android.content.Context;
import android.database.Cursor;

public interface CursorAdapterParameter<I, T> {

    Context getContext();

    Cursor getCursor();

    ViewBinder<I, T> getViewBinder();

    CursorAdapter.CursorCreator<I> getCursorCreator();
}
