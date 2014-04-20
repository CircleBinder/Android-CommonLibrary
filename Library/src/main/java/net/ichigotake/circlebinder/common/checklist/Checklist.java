package net.ichigotake.circlebinder.common.checklist;

import android.os.Parcel;

public final class Checklist implements android.os.Parcelable {

    private final ChecklistColor color;
    private final String name;

    Checklist(ChecklistBuilder builder) {
        color = builder.color;
        name = builder.name;
    }

    public ChecklistColor getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return color.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.color == null ? -1 : this.color.ordinal());
        dest.writeString(this.name);
    }

    private Checklist(Parcel in) {
        int tmpColor = in.readInt();
        this.color = tmpColor == -1 ? null : ChecklistColor.values()[tmpColor];
        this.name = in.readString();
    }

    public static Creator<Checklist> CREATOR = new Creator<Checklist>() {
        public Checklist createFromParcel(Parcel source) {
            return new Checklist(source);
        }

        public Checklist[] newArray(int size) {
            return new Checklist[size];
        }
    };
}

