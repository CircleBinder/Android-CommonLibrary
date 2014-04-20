package circlebinder.common.news;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.ichigotake.common.widget.SectionHeaderBinder;

import circlebinder.common.R;

public final class NewsBinder
        implements SectionHeaderBinder<Feed, NewsViewHolder, NewsHeaderViewHolder> {

    @Override
    public NewsHeaderViewHolder generateHeaderTag(int position, Feed feed, View convertView) {
        return new NewsHeaderViewHolder(convertView);
    }

    @Override
    public View generateHeaderView(int position, Feed feed, LayoutInflater inflater) {
        return inflater.inflate(R.layout.circlebinder_news_header, null);
    }

    @Override
    public void bindHeaderView(int position, Feed feed, NewsHeaderViewHolder holder) {
        holder.getTitle().setText(R.string.circlebinder_home_change_log);
    }

    @Override
    public long getHeaderId(int position, Feed feed) {
        return 0;
    }

    @Override
    public NewsViewHolder generateTag(int position, Feed item, View convertView) {
        return new NewsViewHolder(convertView);
    }

    @Override
    public View generateView(int position, Feed item, LayoutInflater inflater, ViewGroup parent) {
        return inflater.inflate(R.layout.circlebinder_news_item, null);
    }

    @Override
    public void bindView(int position, Feed item, NewsViewHolder tag) {
        tag.getPublishDate().setText(item.getPublishDate().getFormattedDate());
        tag.getTitle().setText(item.getTitle());
    }
}
