package circlebinder.common.checklist;

import android.widget.Spinner;

import net.ichigotake.common.widget.OnItemSelectedEventListener;
import net.ichigotake.common.widget.OnItemSelectedListener;

import java.util.Collection;

public final class ChecklistSelectorContainer {

    private final OnItemSelectedListener<ChecklistColor> onItemSelectedListener;

    public ChecklistSelectorContainer(Spinner selector, Collection<ChecklistColor> selectorItems,
                                      ChecklistColor selectedColor) {
        this.onItemSelectedListener = new OnItemSelectedListener<ChecklistColor>();

        ChecklistSelectorAdapter adapter = new ChecklistSelectorAdapter(selector.getContext());
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

    public void addOnItemSelectedListener(OnItemSelectedEventListener<ChecklistColor> listener) {
        onItemSelectedListener.addOnItemSelectedListener(listener);
    }

}
