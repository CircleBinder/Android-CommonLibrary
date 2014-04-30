package circlebinder.common.checklist;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import circlebinder.common.R;

final class SelectorViewHolder {

    private final TextView name;
    private final ImageView icon;

    public SelectorViewHolder(View convertView) {
        name = (TextView)convertView.findViewById(R.id.circlebinder_spinner_dropdown_item_name);
        icon = (ImageView)convertView.findViewById(R.id.circlebinder_spinner_dropdown_item_icon);
    }

    TextView getName() {
        return name;
    }

    ImageView getIcon() {
        return icon;
    }
}
