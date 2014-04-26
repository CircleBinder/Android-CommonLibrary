package circlebinder.common.circle;

import android.view.View;

import circlebinder.common.event.Circle;
import circlebinder.common.event.CircleLink;

public interface CircleOnClickListener {

    void onItemClick(Circle circle);

    void onCheckBoxClick(Circle circle, CircleViewHolder holder, boolean isChecked);

    void onCircleCutClick(Circle circle);

    void onInfoClick(CircleLink clicked, Circle circle, View view);
}
