package circlebinder.common.circle;

import android.view.View;
import android.widget.TextView;

import circlebinder.common.R;
import circlebinder.common.view.CircleCutView;

public final class CircleViewHolder {

    private final View container;
    private final CircleCutView circleCut;

    private final TextView circleName;
    private final TextView penName;
    private final TextView genre;
    private final TextView space;
    //TODO: リストを扱えるようにする
    private final View link;

    public CircleViewHolder(View container) {
        this.container = container;
        this.circleCut = (CircleCutView)container.findViewById(R.id.checklist_item_circle_cut);
        this.circleName = (TextView)container.findViewById(R.id.checklist_item_circle_name);
        this.penName = (TextView)container.findViewById(R.id.checklist_item_pen_name);
        this.genre = (TextView)container.findViewById(R.id.checklist_item_genre);
        this.space = (TextView)container.findViewById(R.id.checklist_item_space);
        this.link = container.findViewById(R.id.circlebinder_checklist_item_links);
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

    public View getLinks() {
        return link;
    }

}
