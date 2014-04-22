package circlebinder.common.checklist;

import android.os.Parcel;

public final class Checklist implements android.os.Parcelable {

    public static class Builder {

        ChecklistColor color;
        String name;

        public Checklist build() {
            return new Checklist(this);
        }

        public Builder setColor(ChecklistColor color) {
            this.color = color;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

    }

    private final ChecklistColor color;
    private final String name;

    private Checklist(Builder builder) {
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

