package circlebinder.common.checklist;

import android.content.Context;

import net.ichigotake.common.widget.ArrayAdapter;
import net.ichigotake.common.widget.ViewBinder;

public final class CircleCheckSelectorAdapter extends ArrayAdapter<CircleCheck, SelectorViewHolder> {

    public CircleCheckSelectorAdapter(Context context, ViewBinder<CircleCheck, SelectorViewHolder> binder) {
        super(context, binder);
    }
}
