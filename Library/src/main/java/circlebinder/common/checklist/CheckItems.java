package circlebinder.common.checklist;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import circlebinder.common.event.CheckItem;

public final class CheckItems {

    private final List<CheckItem> items;

    public CheckItems() {
        this.items = new CopyOnWriteArrayList<CheckItem>();
    }

    public CheckItems(List<CheckItem> items) {
        this.items = items;
    }

    public CheckItem get(int location) {
        return items.get(location);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public List<CheckItem> toList() {
        return items;
    }

}
