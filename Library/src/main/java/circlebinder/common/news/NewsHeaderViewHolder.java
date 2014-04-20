package circlebinder.common.news;

import android.view.View;
import android.widget.TextView;

public final class NewsHeaderViewHolder {

    private final TextView title;

    public NewsHeaderViewHolder(View convertView) {
        title = (TextView)convertView;
    }

    public TextView getTitle() {
        return title;
    }

}
