package circlebinder.common.changelog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import circlebinder.common.R;

public class ChangeLogFeedAdapter
        extends SectionHeaderItemAdapter<ChangeLogFeed, ChangeLogFeedViewHolder, ChangeLogHeaderViewHolder> {

    public ChangeLogFeedAdapter(Context context) {
        super(context);
    }

    @Override
    protected View generateView(int position, ChangeLogFeed item, LayoutInflater inflater, ViewGroup parent) {
        return inflater.inflate(R.layout.circlebinder_dashboard_item, parent, false);
    }

    @Override
    protected void bindView(int position, ChangeLogFeed item, ChangeLogFeedViewHolder tag) {
        tag.getLabel().setText(item.getTitle());
    }

    @Override
    protected ChangeLogFeedViewHolder generateTag(int position, ChangeLogFeed item, View convertView) {
        return new ChangeLogFeedViewHolder(convertView);
    }

    @Override
    protected ChangeLogHeaderViewHolder generateHeaderTag(int position, ChangeLogFeed item, View convertView) {
        return new ChangeLogHeaderViewHolder(convertView);
    }

    @Override
    protected View generateHeaderView(int position, ChangeLogFeed changeLogFeed, LayoutInflater inflater) {
        return inflater.inflate(R.layout.circlebinder_dashboard_header, null);
    }

    @Override
    protected void bindHeaderView(int position, ChangeLogFeed item, ChangeLogHeaderViewHolder tag) {
        tag.getLabel().setText(tag.getLabel().getContext().getString(
                R.string.circlebinder_change_log_publish_date_format,
                item.getPublishDate().getFormattedDate(),
                item.getVersionName()
        ));
    }

    @Override
    protected long getHeaderId(int position, ChangeLogFeed changeLogFeed) {
        return changeLogFeed.getVersionCode();
    }

}
