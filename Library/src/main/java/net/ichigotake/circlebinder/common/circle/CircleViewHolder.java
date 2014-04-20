package net.ichigotake.circlebinder.common.circle;

import android.view.View;
import android.widget.TextView;

import net.ichigotake.circlebinder.common.R;
import net.ichigotake.circlebinder.common.view.CircleCutView;

public final class CircleViewHolder {

    private final View container;
    private final CircleCutView circleCut;

    private final TextView circleName;
    private final TextView penName;
    private final TextView genre;
    private final TextView space;

    public CircleViewHolder(View container) {
        this.container = container;
        this.circleCut = (CircleCutView)container.findViewById(R.id.checklist_item_circle_cut);
        this.circleName = (TextView)container.findViewById(R.id.checklist_item_circle_name);
        this.penName = (TextView)container.findViewById(R.id.checklist_item_pen_name);
        this.genre = (TextView)container.findViewById(R.id.checklist_item_genre);
        this.space = (TextView)container.findViewById(R.id.checklist_item_space);
    }

    public View getContainer() {
        return container;
    }

    public CircleCutView getCircleCut() {
        return circleCut;
    }

    public TextView getCircleName() {
        return circleName;
    }

    public TextView getPenName() {
        return penName;
    }

    public TextView getGenre() {
        return genre;
    }

    public TextView getSpace() {
        return space;
    }

}