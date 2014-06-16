package circlebinder.common.changelog;

import android.view.View;
import android.widget.TextView;

import circlebinder.common.R;

public final class ChangeLogFeedViewHolder {

    private final TextView title;

    public ChangeLogFeedViewHolder(View convertView) {
        title = (TextView)convertView.findViewById(R.id.circlebinder_dashboard_item_label);
    }

    public TextView getLabel() {
        return title;
    }

}
