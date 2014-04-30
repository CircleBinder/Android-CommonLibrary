package circlebinder.common.checklist;

import android.content.Context;
import android.widget.Spinner;

import net.ichigotake.common.widget.OnItemSelectedEventListener;
import net.ichigotake.common.widget.OnItemSelectedListener;

public final class CircleCheckSelectorContainer {

    private final Context context;
    private final Spinner selector;
    private final OnItemSelectedListener<CircleCheck> onItemSelectedListener;

    public CircleCheckSelectorContainer(Spinner selector) {
        this.context = selector.getContext();
        this.selector = selector;
        this.onItemSelectedListener = new OnItemSelectedListener<CircleCheck>();
    }

    public void addOnItemSelectedListener(OnItemSelectedEventListener<CircleCheck> listener) {
        onItemSelectedListener.addOnItemSelectedListener(listener);
    }

    public void initialize(boolean isChecked) {
        CircleCheckBinder binder = new CircleCheckBinder();
        CircleCheckSelectorAdapter adapter = new CircleCheckSelectorAdapter(context, binder);
        adapter.clear();
        for (CircleCheck status : CircleCheck.values()) {
            adapter.add(status);
        }
        selector.setAdapter(adapter);
        selector.setSelection(CircleCheck.get(isChecked).getId());
        selector.setOnItemSelectedListener(onItemSelectedListener);
    }

}
