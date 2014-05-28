package circlebinder.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import circlebinder.common.R;

public class CircleCutView extends RelativeLayout {

    private ImageView imageView;

    public CircleCutView(Context context) {
        super(context);
        if (isInEditMode()) {
            initialize(context);
        }
    }

    public CircleCutView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (isInEditMode()) {
            initialize(context);
        }
    }

    public CircleCutView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (isInEditMode()) {
            initialize(context);
        }
    }

    private void initialize(Context context) {
        LayoutInflater.from(context).inflate(R.layout.circlebinder_view_circle_cut, this);
        imageView = (ImageView)findViewById(R.id.view_circle_cut_image);
    }
}
