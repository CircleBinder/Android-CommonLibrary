package circlebinder.common.circle;

import circlebinder.common.event.Circle;

public interface CircleOnClickListener {

    void onItemClick(Circle circle, int position);

    void onCheckBoxClick(Circle circle, CircleViewHolder holder, boolean isChecked);

    void onCircleCutClick(Circle circle, int position);

}
