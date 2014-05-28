package circlebinder.common.event;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.ichigotake.common.widget.ViewBinder;

import circlebinder.common.R;
import circlebinder.common.checklist.SelectorViewHolder;

public final class BlockSelectorBinder implements ViewBinder<Block, SelectorViewHolder> {

    @Override
    public SelectorViewHolder generateTag(int position, Block item, View convertView) {
        return new SelectorViewHolder(convertView);
    }

    @Override
    public View generateView(int position, Block item, LayoutInflater inflater, ViewGroup parent) {
        return inflater.inflate(R.layout.circlebinder_spinner_dropdown_item, null);
    }

    @Override
    public void bindView(int position, Block item, SelectorViewHolder tag) {
        tag.getName().setText(item.getName());
    }
}
