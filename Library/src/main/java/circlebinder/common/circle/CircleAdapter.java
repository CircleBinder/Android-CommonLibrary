package circlebinder.common.circle;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.ichigotake.common.widget.CursorAdapter;
import net.ichigotake.common.widget.CursorItemConverter;

import circlebinder.common.R;
import circlebinder.common.event.Circle;

public final class CircleAdapter extends CursorAdapter<Circle, CircleViewHolder> {



    public CircleAdapter(Context context, Cursor cursor, CursorItemConverter<Circle> converter) {
        super(context, cursor, converter);
    }

    @Override
    public CircleViewHolder generateTag(int position, Circle item, View convertView) {
        return new CircleViewHolder(convertView);
    }

    @Override
    public View generateView(int position, Circle item, LayoutInflater inflater, ViewGroup parent) {
        return inflater.inflate(R.layout.circlebinder_circle_list_item, parent, false);
    }

    @Override
    public void bindView(int position, Circle item, CircleViewHolder tag) {
        tag.getCircleName().setText(item.getName());
        tag.getPenName().setText(item.getPenName());

        tag.getSpace().setCompoundDrawablesWithIntrinsicBounds(
                0,
                item.getChecklistColor().getColorDrawable(),
                0,
                0
        );
        tag.getSpace().setText(
                String.format("%s%02d%s",
                        item.getSpace().getBlockName(), item.getSpace().getNo(), item.getSpace().getNoSub())
        );
        tag.getGenre().setText(item.getGenre().getName());
    }

}
