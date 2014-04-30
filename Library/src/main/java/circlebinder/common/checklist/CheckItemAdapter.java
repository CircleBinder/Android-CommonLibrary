package circlebinder.common.checklist;

import net.ichigotake.common.widget.CursorAdapter;
import net.ichigotake.common.widget.CursorAdapterParameter;

import circlebinder.common.event.CheckItem;

public final class CheckItemAdapter extends CursorAdapter<CheckItem, CheckItemViewHolder> {

    public CheckItemAdapter(CursorAdapterParameter<CheckItem, CheckItemViewHolder> parameter) {
        super(parameter);
    }

    public void update() {
        changeCursor(getParameter().getCursor());
    }
}
