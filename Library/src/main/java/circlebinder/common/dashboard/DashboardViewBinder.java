package circlebinder.common.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.ichigotake.common.widget.SectionHeaderBinder;

import circlebinder.common.R;

public final class DashboardViewBinder
        implements SectionHeaderBinder<DashboardItem, DashboardItemViewHolder, DashboardHeaderViewHolder> {

    @Override
    public DashboardHeaderViewHolder generateHeaderTag(int position, DashboardItem item, View convertView) {
        return new DashboardHeaderViewHolder(convertView);
    }

    @Override
    public View generateHeaderView(int position, DashboardItem dashboardItem, LayoutInflater inflater) {
        return inflater.inflate(R.layout.circlebinder_dashboard_header, null);
    }

    @Override
    public void bindHeaderView(int position, DashboardItem item, DashboardHeaderViewHolder holder) {
        holder.getLabel().setText(item.getSectionTitle());
        holder.getLabel().setCompoundDrawablesWithIntrinsicBounds(item.getIconResource(), 0, 0, 0);
    }

    @Override
    public long getHeaderId(int position, DashboardItem item) {
        return item.getSectionTitleId();
    }

    @Override
    public DashboardItemViewHolder generateTag(int position, DashboardItem item, View convertView) {
        return new DashboardItemViewHolder(convertView);
    }

    @Override
    public View generateView(int position, DashboardItem item, LayoutInflater inflater, ViewGroup parent) {
        return inflater.inflate(R.layout.circlebinder_dashboard_item, null);
    }

    @Override
    public void bindView(int position, DashboardItem item, DashboardItemViewHolder tag) {
        tag.getLabel().setText(item.getSectionTitle());
    }
}
