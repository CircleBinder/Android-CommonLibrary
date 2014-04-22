package circlebinder.common.search;

import net.ichigotake.common.widget.CursorAdapter;
import net.ichigotake.common.widget.CursorAdapterParameter;

import circlebinder.common.circle.CircleViewHolder;
import circlebinder.common.event.Circle;

/**
 * TODO: SectionIndexerの実装
 */
public final class CircleAdapter extends CursorAdapter<Circle, CircleViewHolder> {

    public CircleAdapter(CursorAdapterParameter<Circle, CircleViewHolder> parameter) {
        super(parameter);
    }

}
