package circlebinder.common.news;

import android.view.View;
import android.widget.TextView;

import circlebinder.common.R;

final class NewsViewHolder {

    private final TextView publishDate;
    private final TextView title;

    public NewsViewHolder(View convertView) {
        publishDate = (TextView)convertView.findViewById(R.id.circlebinder_news_item_publish_date);
        title = (TextView)convertView.findViewById(R.id.circlebinder_news_item_title);
    }

    public TextView getPublishDate() {
        return publishDate;
    }

    public TextView getTitle() {
        return title;
    }

}
