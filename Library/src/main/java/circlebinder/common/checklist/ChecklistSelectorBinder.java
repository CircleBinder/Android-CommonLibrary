package circlebinder.common.checklist;

import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.ichigotake.common.widget.ViewBinder;

import circlebinder.common.R;

final class ChecklistSelectorBinder implements ViewBinder<ChecklistColor, SelectorViewHolder> {

    @Override
    public SelectorViewHolder generateTag(int position, ChecklistColor item, View convertView) {
        return new SelectorViewHolder(convertView);
    }

    @Override
    public View generateView(int position, ChecklistColor item, LayoutInflater inflater, ViewGroup parent) {
        return inflater.inflate(R.layout.circlebinder_spinner_dropdown_item, null);
    }

    @Override
    public void bindView(int position, ChecklistColor item, SelectorViewHolder tag) {
        tag.getName().setText(item.getName());
        tag.getIcon().setImageDrawable(new ColorDrawable(item.getColor()));
    }

}
