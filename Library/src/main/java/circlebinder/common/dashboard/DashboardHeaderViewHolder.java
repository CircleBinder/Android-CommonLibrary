package circlebinder.common.dashboard;

import android.view.View;
import android.widget.TextView;

final class DashboardHeaderViewHolder {

    private final TextView label;

    DashboardHeaderViewHolder(View view) {
        label = (TextView)view;
    }

    TextView getLabel() {
        return label;
    }
}
