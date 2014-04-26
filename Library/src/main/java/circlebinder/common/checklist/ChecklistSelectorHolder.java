package circlebinder.common.checklist;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import circlebinder.common.R;

final class ChecklistSelectorHolder {

    private final TextView name;
    private final ImageView icon;

    public ChecklistSelectorHolder(View convertView) {
        name = (TextView)convertView.findViewById(R.id.circlebinder_checklist_spinner_dropdown_item_name);
        icon = (ImageView)convertView.findViewById(R.id.circlebinder_checklist_spinner_dropdown_item_icon);
    }

    TextView getName() {
        return name;
    }

    ImageView getIcon() {
        return icon;
    }
}
