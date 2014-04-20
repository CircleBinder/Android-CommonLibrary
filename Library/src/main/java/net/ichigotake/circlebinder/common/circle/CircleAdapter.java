package net.ichigotake.circlebinder.common.circle;

import net.ichigotake.circlebinder.common.event.Circle;
import net.ichigotake.common.widget.CursorAdapter;
import net.ichigotake.common.widget.CursorAdapterParameter;

public final class CircleAdapter extends CursorAdapter<Circle, CircleViewHolder> {

    public CircleAdapter(CursorAdapterParameter<Circle, CircleViewHolder> parameter) {
        super(parameter);
    }
}
