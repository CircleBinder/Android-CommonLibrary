package circlebinder.common.checklist;

import android.view.View;
import android.widget.TextView;

import circlebinder.common.R;

public final class CheckItemViewHolder {

    private final TextView price;
    private final TextView name;

    public CheckItemViewHolder(View convertView) {
        price = (TextView)convertView.findViewById(R.id.circlebinder_circle_memo_item_price);
        name = (TextView)convertView.findViewById(R.id.circlebinder_circle_memo_item_name);
    }

    public TextView getPrice() {
        return price;
    }

    public TextView getName() {
        return name;
    }
}
