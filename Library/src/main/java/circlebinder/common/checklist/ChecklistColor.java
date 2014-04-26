package circlebinder.common.checklist;

import android.graphics.Color;

import circlebinder.Legacy;

//TODO: インターフェースをすっきりさせたい
public enum ChecklistColor implements Legacy {
    ALL(-1, "全て", "#ffffffff"),
    NONE(0, "お気に入りからはずす", "#dddddd"),
    ORANGE(1, "お気に入り", "#FF944A"),
    PINK(2, "お気に入り", "#FF00FF"),
    YELLOW(3, "お気に入り", "#FFF700"),
    GREEN(4, "お気に入り", "#00B54A"),
    LIGHT_BLUE(5, "お気に入り", "#00B5FF"),
    PURPLE(6, "お気に入り", "#9C529C"),
    BLUE(7, "お気に入り", "#0000FF"),
    LIGHT_GREEN(8, "お気に入り", "#00FF00"),
    RED(9, "お気に入り", "#FF0000"),
    ;

    final private int mId;
    final private String mName;
    final private int mColor;

    private ChecklistColor(int id, String name, String colorCode) {
        mId = id;
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
