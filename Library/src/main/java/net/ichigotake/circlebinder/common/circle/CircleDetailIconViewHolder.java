package net.ichigotake.circlebinder.common.circle;

import android.view.View;
import android.widget.ImageView;

import net.ichigotake.circlebinder.common.R;

class CircleDetailIconViewHolder {

    private final ImageView icon;

    CircleDetailIconViewHolder(View container) {
        icon = (ImageView) container.findViewById(R.id.circle_detail_icon);
    }

    ImageView getIcon() {
        return icon;
    }
}
