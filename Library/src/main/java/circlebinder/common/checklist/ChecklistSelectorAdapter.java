package circlebinder.common.checklist;

import android.content.Context;

import net.ichigotake.common.widget.ArrayAdapter;
import net.ichigotake.common.widget.ViewBinder;

final class ChecklistSelectorAdapter extends ArrayAdapter<ChecklistColor, ChecklistSelectorHolder> {

    public ChecklistSelectorAdapter(Context context,
                                    ViewBinder<ChecklistColor, ChecklistSelectorHolder> binder) {
        super(context, binder);
    }

}
