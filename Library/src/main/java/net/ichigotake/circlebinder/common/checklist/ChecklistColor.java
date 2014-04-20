package net.ichigotake.circlebinder.common.checklist;

import android.graphics.Color;

import net.ichigotake.circlebinder.Legacy;

public enum ChecklistColor implements Legacy {
    ORANGE(0, "チェックリスト", "#FF944A"),
    PINK(1, "チェックリスト", "#FF00FF"),
    YELLOW(2, "チェックリスト", "#FFF700"),
    GREEN(3, "チェックリスト", "#00B54A"),
    LIGHT_BLUE(4, "チェックリスト", "#00B5FF"),
    PURPLE(5, "チェックリスト", "#9C529C"),
    BLUE(6, "チェックリスト", "#0000FF"),
    LIGHT_GREEN(7, "チェックリスト", "#00FF00"),
    RED(8, "チェックリスト", "#FF0000"),
    NONE(9, "お気に入りからはずす", "#dddddd"),
    ALL(10, "全て", "#ffffffff"),
    ;

    final private int mId;
    final private String mName;
    final private String mColorCode;
    final private int mColor;

    private ChecklistColor(int id, String name, String colorCode) {
        mId = id;
        mName = name;
        mColorCode = colorCode;
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
            if (ALL != color) {
                colors[color.getId()] = color.getColor();
            }
        }
        return colors;
    }

    public static ChecklistColor get(int color) {
        ChecklistColor value = NONE;
        for (ChecklistColor item : values()) {
            if (item.getColor() == color) {
                value = item;
            }
        }
        return value;
    }

    public static ChecklistColor[] checklists() {
        ChecklistColor[] values = values();
        ChecklistColor[] colors = new ChecklistColor[values.length-2];
        for (ChecklistColor color : values) {
            if (NONE != color && ALL != color) {
                colors[color.getId()] = color;
            }
        }
        return colors;
    }

    public static boolean is(CharSequence constraint) {
        return constraint.toString().equals("" + ALL.getId());
    }
}
