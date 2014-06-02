package circlebinder.common.circle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.ichigotake.common.widget.ViewBinder;

import circlebinder.common.R;
import circlebinder.common.event.Circle;

public final class CircleViewBinder implements ViewBinder<Circle, CircleViewHolder> {

    @Override
    public CircleViewHolder generateTag(int position, Circle item, View convertView) {
        return new CircleViewHolder(convertView);
    }

    @Override
    public View generateView(int position, Circle item, LayoutInflater inflater, ViewGroup parent) {
        return inflater.inflate(R.layout.circlebinder_circle_list_item, null);
    }

    @Override
    public void bindView(int position, Circle item, CircleViewHolder tag) {
        int backgroundColor = item.getChecklistColor().getColor() + 0xcc000000;

        tag.getSpace().setBackgroundColor(backgroundColor);
        tag.getCircleName().setText(item.getName());
        tag.getPenName().setText(item.getPenName());

        tag.getCircleCut().setVisibility(View.GONE);
        tag.getSpace().setText(
                String.format("%s\n%02d%s",
                        item.getSpace().getBlockName(), item.getSpace().getNo(), item.getSpace().getNoSub())
        );
        tag.getGenre().setText(item.getGenre().getName());
    }

}
