package circlebinder.common.changelog;

import android.content.Context;

import net.ichigotake.common.widget.SectionHeaderArrayAdapter;

public abstract class SectionHeaderItemAdapter<ITEM, ITEM_TAG, HEADER_TAG>
        extends SectionHeaderArrayAdapter<ITEM, ITEM_TAG, HEADER_TAG> {

    public SectionHeaderItemAdapter(Context context) {
        super(context);
    }

}
