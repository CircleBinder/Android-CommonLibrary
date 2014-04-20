package net.ichigotake.circlebinder.common.circle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.ichigotake.circlebinder.common.R;
import net.ichigotake.circlebinder.common.event.Circle;
import net.ichigotake.common.widget.ViewBinder;

public final class CircleViewBinder implements ViewBinder<Circle, CircleViewHolder> {

    private final CircleOnClickListener listener;

    public CircleViewBinder(CircleOnClickListener listener) {
        this.listener = listener;
    }

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

        tag.getContainer().setBackgroundColor(backgroundColor);
        tag.getContainer().setOnClickListener(new OnCircleClickListener(listener, item));
        tag.getCircleName().setText(item.getName());
        tag.getPenName().setText(item.getPenName());
        tag.getCircleCut().setOnClickListener(new OnCircleCutClickListener(listener, item));

        tag.getCircleCut().setVisibility(View.GONE);
        tag.getSpace().setText(
                String.format("%s\n%02d%s",
                        item.getSpace().getBlockName(), item.getSpace().getNo(), item.getSpace().getNoSub())
        );
        tag.getGenre().setText("");
    }

    private static class OnCircleClickListener implements View.OnClickListener {

        private final CircleOnClickListener listener;
        private final Circle circle;

        OnCircleClickListener(CircleOnClickListener listener, Circle circle) {
            this.listener = listener;
            this.circle = circle;
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(circle);
        }
    }

    private final static class OnCircleCutClickListener implements View.OnClickListener {

        private final CircleOnClickListener listener;
        private final Circle circle;

        private OnCircleCutClickListener(CircleOnClickListener listener, Circle circle) {
            this.listener = listener;
            this.circle = circle;
        }

        @Override
        public void onClick(View v) {
            listener.onCircleCutClick(circle);
        }
    }
}
