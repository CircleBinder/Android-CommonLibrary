package circlebinder.common.dashboard;

import android.view.View;
import android.widget.TextView;

import circlebinder.common.R;

final class DashboardItemViewHolder {

    private final TextView title;

    public DashboardItemViewHolder(View convertView) {
        title = (TextView)convertView.findViewById(R.id.circlebinder_dashboard_item_label);
    }

    public TextView getLabel() {
        return title;
    }

}
