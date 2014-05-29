package circlebinder.common.checklist;

import android.content.Context;
import android.widget.Spinner;

import net.ichigotake.common.widget.OnItemSelectedEventListener;
import net.ichigotake.common.widget.OnItemSelectedListener;

import java.util.Collection;

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

    public void initialize(Collection<ChecklistColor> selectorItems, ChecklistColor selectedColor) {
        ChecklistSelectorBinder binder = new ChecklistSelectorBinder();
        ChecklistSelectorAdapter adapter = new ChecklistSelectorAdapter(context, binder);
        adapter.clear();

        int position = 0;
        int presetPosition = 0;
        for (ChecklistColor color : selectorItems) {
            adapter.add(color);
            if (color.equals(selectedColor)) {
                presetPosition = position;
            }
            position++;
        }
        selector.setAdapter(adapter);
        selector.setSelection(presetPosition);
        selector.setOnItemSelectedListener(onItemSelectedListener);
    }

}
