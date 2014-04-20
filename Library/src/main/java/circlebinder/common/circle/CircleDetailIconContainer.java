package circlebinder.common.circle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import circlebinder.common.R;

public final class CircleDetailIconContainer {

    private final ViewGroup container;
    private final LayoutInflater inflater;

    public CircleDetailIconContainer(ViewGroup container) {
        this.container = container;
        this.inflater = LayoutInflater.from(container.getContext());
    }

    public void add(CircleDetailIcon icon) {
        View iconContainer = inflater.inflate(R.layout.circlebinder_circle_detail_icon, null);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        ((ImageView)iconContainer.findViewById(R.id.circle_detail_icon))
                .setImageResource(icon.getIconResource());
        container.addView(iconContainer, params);
    }

}
