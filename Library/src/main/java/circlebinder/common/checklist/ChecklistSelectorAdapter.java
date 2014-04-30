package circlebinder.common.checklist;

import android.content.Context;

import net.ichigotake.common.widget.ArrayAdapter;
import net.ichigotake.common.widget.ViewBinder;

final class ChecklistSelectorAdapter extends ArrayAdapter<ChecklistColor, SelectorViewHolder> {

    public ChecklistSelectorAdapter(Context context,
                                    ViewBinder<ChecklistColor, SelectorViewHolder> binder) {
        super(context, binder);
    }

}
