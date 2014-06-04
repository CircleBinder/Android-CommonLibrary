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
    }

    public CircleCutView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleCutView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onFinishInflate() {
        if (!isInEditMode()) {
            LayoutInflater.from(getContext()).inflate(R.layout.circlebinder_view_circle_cut, this);
            imageView = (ImageView)findViewById(R.id.view_circle_cut_image);
        }
    }
}
