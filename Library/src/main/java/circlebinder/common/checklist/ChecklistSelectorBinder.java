package circlebinder.common.checklist;

import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.ichigotake.common.widget.ViewBinder;

import circlebinder.common.R;

final class ChecklistSelectorBinder implements ViewBinder<ChecklistColor, ChecklistSelectorHolder> {

    @Override
    public ChecklistSelectorHolder generateTag(int position, ChecklistColor item, View convertView) {
        return new ChecklistSelectorHolder(convertView);
    }

    @Override
    public View generateView(int position, ChecklistColor item, LayoutInflater inflater, ViewGroup parent) {
        return inflater.inflate(R.layout.circlebinder_checklist_spinner_dropdown_item, null);
    }

    @Override
    public void bindView(int position, ChecklistColor item, ChecklistSelectorHolder tag) {
        tag.getName().setText(item.getName());
        tag.getIcon().setImageDrawable(new ColorDrawable(item.getColor()));
    }

}
