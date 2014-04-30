package circlebinder.common.checklist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.ichigotake.common.widget.ViewBinder;

import circlebinder.common.R;

final class CircleCheckBinder implements ViewBinder<CircleCheck, SelectorViewHolder> {
    @Override
    public SelectorViewHolder generateTag(int position, CircleCheck item, View convertView) {
        SelectorViewHolder holder = new SelectorViewHolder(convertView);
        holder.getIcon().setVisibility(View.GONE);
        return holder;
    }

    @Override
    public View generateView(int position, CircleCheck item, LayoutInflater inflater, ViewGroup parent) {
        return inflater.inflate(R.layout.circlebinder_spinner_dropdown_item, null);
    }

    @Override
    public void bindView(int position, CircleCheck item, SelectorViewHolder tag) {
        tag.getName().setText(item.getStatusNameResource());
    }
}
