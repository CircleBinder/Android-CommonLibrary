package circlebinder.common.circle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.ichigotake.common.widget.ViewBinder;

import circlebinder.common.R;
import circlebinder.common.event.Circle;

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
        tag.getContainer().setOnClickListener(new OnCircleClickListener(listener, item, position));
        tag.getCircleName().setText(item.getName());
        tag.getPenName().setText(item.getPenName());
        tag.getCircleCut().setOnClickListener(new OnCircleCutClickListener(listener, item, position));
        //TODO: 外部リンクを複数設置出来るようにする。今は1つで決め打ち
        if (item.getLinks().isEmpty()) {
            tag.getLinks().setVisibility(View.GONE);
        } else {
            tag.getLinks().setVisibility(View.VISIBLE);
        }

        tag.getCircleCut().setVisibility(View.GONE);
        tag.getCheckBox().setChecked(item.isChecked());
        listener.onCheckBoxClick(item, tag, item.isChecked());
        tag.getSpace().setOnClickListener(new OnCircleCheckBoxClickListener(item, tag, listener));
        tag.getSpace().setText(
                String.format("%s\n%02d%s",
                        item.getSpace().getBlockName(), item.getSpace().getNo(), item.getSpace().getNoSub())
        );
        tag.getGenre().setText(item.getGenre().getName());
    }

    private static class OnCircleClickListener implements View.OnClickListener {

        private final CircleOnClickListener listener;
        private final Circle circle;
        private final int position;

        OnCircleClickListener(CircleOnClickListener listener, Circle circle, int position) {
            this.listener = listener;
            this.circle = circle;
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(circle, position);
        }
    }

    private final static class OnCircleCutClickListener implements View.OnClickListener {

        private final CircleOnClickListener listener;
        private final Circle circle;
        private final int position;

        private OnCircleCutClickListener(CircleOnClickListener listener, Circle circle, int position) {
            this.listener = listener;
            this.circle = circle;
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            listener.onCircleCutClick(circle, position);
        }
    }
}
