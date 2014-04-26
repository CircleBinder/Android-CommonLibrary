package circlebinder.common.checklist;

import android.content.Context;
import android.widget.Spinner;

import net.ichigotake.common.widget.OnItemSelectedEventListener;
import net.ichigotake.common.widget.OnItemSelectedListener;

public final class ChecklistSelectorContainer {

    private final Context context;
    private final Spinner selector;
    private final OnItemSelectedListener<ChecklistColor> onItemSelectedListener;

    public ChecklistSelectorContainer(Spinner selector) {
        this.context = selector.getContext();
        this.selector = selector;
        this.onItemSelectedListener = new OnItemSelectedListener<ChecklistColor>();
    }

    public void addOnItemSelectedListener(OnItemSelectedEventListener<ChecklistColor> listener) {
        onItemSelectedListener.addOnItemSelectedListener(listener);
    }

    public void initialize() {
        ChecklistSelectorBinder binder = new ChecklistSelectorBinder();
        ChecklistSelectorAdapter adapter = new ChecklistSelectorAdapter(context, binder);
        adapter.clear();
        adapter.add(ChecklistColor.ALL);
        for (ChecklistColor color : ChecklistColor.checklists()) {
            adapter.add(color);
        }
        selector.setAdapter(adapter);
        selector.setOnItemSelectedListener(onItemSelectedListener);
    }

}
