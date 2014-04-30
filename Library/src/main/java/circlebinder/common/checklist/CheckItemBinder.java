package circlebinder.common.checklist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.ichigotake.common.widget.ViewBinder;

import circlebinder.common.R;
import circlebinder.common.event.CheckItem;

public final class CheckItemBinder implements ViewBinder<CheckItem, CheckItemViewHolder> {

    @Override
    public CheckItemViewHolder generateTag(int position, CheckItem item, View convertView) {
        return new CheckItemViewHolder(convertView);
    }

    @Override
    public View generateView(int position, CheckItem item, LayoutInflater inflater, ViewGroup parent) {
        return inflater.inflate(R.layout.circlebinder_circle_check_item, null);
    }

    @Override
    public void bindView(int position, CheckItem item, CheckItemViewHolder tag) {
        tag.getName().setText(item.getName());
        tag.getPrice().setText(item.getNum() + " x " + item.getPrice());
    }

}
