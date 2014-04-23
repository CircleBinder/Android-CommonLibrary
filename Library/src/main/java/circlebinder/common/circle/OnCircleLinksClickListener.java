package circlebinder.common.circle;

import android.view.View;

import circlebinder.common.event.Circle;
import circlebinder.common.event.CircleLink;

class OnCircleLinksClickListener implements View.OnClickListener {

    private final CircleOnClickListener listener;
    private final CircleLink link;
    private final Circle circle;

    OnCircleLinksClickListener(CircleOnClickListener listener, CircleLink link, Circle circle) {
        this.circle = circle;
        this.link = link;
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        listener.onInfoClick(link, circle, v);
    }
}
