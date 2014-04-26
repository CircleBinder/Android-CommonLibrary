package circlebinder.common.circle;

import android.view.View;

import circlebinder.common.event.Circle;

final class OnCircleCheckBoxClickListener implements View.OnClickListener {

    private final Circle item;
    private final CircleViewHolder holder;
    private final CircleOnClickListener listener;

    OnCircleCheckBoxClickListener(Circle item, CircleViewHolder holder, CircleOnClickListener listener) {
        this.item = item;
        this.holder = holder;
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        holder.getCheckBox().toggle();
        listener.onCheckBoxClick(item, holder, holder.getCheckBox().isChecked());
    }
}
