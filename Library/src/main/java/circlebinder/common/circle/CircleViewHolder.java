package circlebinder.common.circle;

import android.view.View;
import android.widget.CheckBox;
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
    private final CheckBox checkBox;
    //TODO: リストを扱えるようにする
    private final View link;

    public CircleViewHolder(View container) {
        this.container = container;
        this.circleCut = (CircleCutView)container.findViewById(R.id.checklist_item_circle_cut);
        this.circleName = (TextView)container.findViewById(R.id.checklist_item_circle_name);
        this.penName = (TextView)container.findViewById(R.id.checklist_item_pen_name);
        this.genre = (TextView)container.findViewById(R.id.checklist_item_genre);
        this.space = (TextView)container.findViewById(R.id.checklist_item_space);
        this.checkBox = (CheckBox)container.findViewById(R.id.checklist_item_checkbox);
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

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public View getLinks() {
        return link;
    }

}
