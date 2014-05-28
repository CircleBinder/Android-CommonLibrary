package circlebinder.common.checklist;

import android.graphics.Color;

import circlebinder.Legacy;
import circlebinder.common.R;

//TODO: インターフェースをすっきりさせたい
public enum ChecklistColor implements Legacy {
    ALL(-1, R.drawable.ic_checklist_none, "全て", "#aaaaaa"),
    NONE(0, R.drawable.ic_checklist_none, "お気に入りからはずす", "#aaaaaa"),
    ORANGE(1, R.drawable.ic_checklist_orange, "お気に入り", "#FF944A"),
    PINK(2, R.drawable.ic_checklist_pink, "お気に入り", "#FF00FF"),
    YELLOW(3, R.drawable.ic_checklist_yellow, "お気に入り", "#FFF700"),
    GREEN(4, R.drawable.ic_checklist_green, "お気に入り", "#00B54A"),
    LIGHT_BLUE(5, R.drawable.ic_checklist_light_blue, "お気に入り", "#00B5FF"),
    PURPLE(6, R.drawable.ic_checklist_purple, "お気に入り", "#9C529C"),
    BLUE(7, R.drawable.ic_checklist_blue, "お気に入り", "#0000FF"),
    LIGHT_GREEN(8, R.drawable.ic_checklist_light_green, "お気に入り", "#00FF00"),
    RED(9, R.drawable.ic_checklist_red, "お気に入り", "#FF0000"),
    ;

    final private int mId;
    final private int mColorDrawable;
    final private String mName;
    final private int mColor;

    private ChecklistColor(int id, int colorDrawable, String name, String colorCode) {
        mId = id;
        this.mColorDrawable = colorDrawable;
        mName = name;
        mColor = Color.parseColor(colorCode);
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public int getColor() {
        return mColor;
    }

    public int getColorDrawable() {
        return mColorDrawable;
    }

    @Override
    public String toString() {
        return mName;
    }

    public static ChecklistColor valueOf(int ordinal) {
        return values()[ordinal];
    }

    public static int[] colors() {
        ChecklistColor[] values = values();
        int[] colors = new int[values.length-1];
        for (ChecklistColor color : values) {
            if (color.getId() > 0) {
                colors[color.getId()-1] = color.getColor();
            }
        }
        colors[colors.length-1] = NONE.getColor();
        return colors;
    }

    public static ChecklistColor getByColor(int color) {
        ChecklistColor value = NONE;
        for (ChecklistColor item : values()) {
            if (item.getColor() == color) {
                value = item;
            }
        }
        return value;
    }

    public static ChecklistColor getById(int id) {
        for (ChecklistColor color : values()) {
            if (id == color.getId()) {
                return color;
            }
        }
        return NONE;
    }

    public static ChecklistColor[] checklists() {
        ChecklistColor[] values = values();
        ChecklistColor[] colors = new ChecklistColor[values.length-2];
        for (ChecklistColor color : values) {
            if (color.getId() > 0) {
                colors[color.getId()-1] = color;
            }
        }
        return colors;
    }

    public static boolean isChecklist(ChecklistColor checklist) {
        return checklist.getId() > 0;
    }

}
