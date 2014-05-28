package circlebinder.common.circle;

import circlebinder.common.event.Circle;

public interface CircleOnClickListener {

    void onItemClick(Circle circle, int position);

    void onCircleCutClick(Circle circle, int position);

}
