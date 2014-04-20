package circlebinder.common.search;

import circlebinder.common.circle.CircleViewHolder;
import circlebinder.common.event.Circle;
import net.ichigotake.common.widget.CursorAdapter;
import net.ichigotake.common.widget.CursorAdapterParameter;

/**
 * TODO: SectionIndexerの実装
 */
public final class CircleAdapter extends CursorAdapter<Circle, CircleViewHolder> {

    public CircleAdapter(CursorAdapterParameter<Circle, CircleViewHolder> parameter) {
        super(parameter);
    }

}
