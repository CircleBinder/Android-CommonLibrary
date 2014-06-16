package circlebinder.common.changelog;

import android.view.View;
import android.widget.TextView;

public final class ChangeLogHeaderViewHolder {

    private final TextView label;

    public ChangeLogHeaderViewHolder(View view) {
        label = (TextView)view;
    }

    public TextView getLabel() {
        return label;
    }
}
