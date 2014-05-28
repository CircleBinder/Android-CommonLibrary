package circlebinder.common.search;

import android.os.Parcelable;

import circlebinder.common.checklist.ChecklistColor;
import circlebinder.common.event.Block;

public interface CircleSearchOption extends Parcelable {
    Order getOrder();

    boolean hasKeyword();

    CharSequence getKeyword();

    boolean hasBlock();

    Block getBlock();

    boolean hasChecklist();

    ChecklistColor getChecklist();
}
