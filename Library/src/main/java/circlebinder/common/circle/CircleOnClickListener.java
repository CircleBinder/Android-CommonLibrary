package circlebinder.common.circle;

import android.view.View;

import circlebinder.common.event.Circle;

public interface CircleOnClickListener {

    void onItemClick(Circle circle, int position);

    void onCircleCutClick(Circle circle, int position);

    void onSpaceClick(Circle item, int position, View target);
}
