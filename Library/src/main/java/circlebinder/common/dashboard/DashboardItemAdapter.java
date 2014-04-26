package circlebinder.common.dashboard;

import android.content.Context;

import net.ichigotake.common.widget.SectionHeaderArrayAdapter;
import net.ichigotake.common.widget.SectionHeaderBinder;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

public final class DashboardItemAdapter
        extends SectionHeaderArrayAdapter<DashboardItem, DashboardItemViewHolder, DashboardHeaderViewHolder>
        implements StickyListHeadersAdapter {

    public DashboardItemAdapter(
            Context context,
            SectionHeaderBinder<DashboardItem, DashboardItemViewHolder, DashboardHeaderViewHolder> binder
    ) {
        super(context, binder);
    }

}
