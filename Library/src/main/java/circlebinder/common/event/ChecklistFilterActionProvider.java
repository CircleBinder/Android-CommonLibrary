package circlebinder.common.event;

import android.content.Context;
import android.support.v4.view.ActionProvider;
import android.view.View;
import android.widget.Spinner;

import net.ichigotake.common.widget.OnItemSelectedEventListener;

import java.util.Collection;

import circlebinder.common.checklist.ChecklistColor;
import circlebinder.common.checklist.ChecklistSelectorContainer;

public final class ChecklistFilterActionProvider extends ActionProvider {

    private final Spinner selector;
    private ChecklistSelectorContainer container;

    public ChecklistFilterActionProvider(Context context, Collection<ChecklistColor> checklists) {
        super(context);
        selector = new Spinner(getContext());
        container = new ChecklistSelectorContainer(selector);
        container.initialize(checklists, ChecklistColor.ALL);
    }

    public void addOnItemSelectedListener(OnItemSelectedEventListener<ChecklistColor> listener) {
        container.addOnItemSelectedListener(listener);
    }

    @Override
    public View onCreateActionView() {
        return selector;
    }

    @Override
    public boolean onPerformDefaultAction() {
        return super.onPerformDefaultAction();
    }

}
