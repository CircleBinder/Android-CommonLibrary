package circlebinder.common.news;

import android.content.Context;

import net.ichigotake.common.widget.SectionHeaderArrayAdapter;
import net.ichigotake.common.widget.SectionHeaderBinder;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

public final class NewsAdapter extends SectionHeaderArrayAdapter<Feed, NewsViewHolder, NewsHeaderViewHolder>
        implements StickyListHeadersAdapter {

    public NewsAdapter(Context context, SectionHeaderBinder<Feed, NewsViewHolder, NewsHeaderViewHolder> binder) {
        super(context, binder);
    }
}
