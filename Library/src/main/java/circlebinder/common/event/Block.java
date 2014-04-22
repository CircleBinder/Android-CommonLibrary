package circlebinder.common.event;

import android.os.Parcel;
import android.os.Parcelable;

public final class Block implements android.os.Parcelable {

    public static class Builder {

        private int id;
        private Area area;

        private String name;

        public Block build() {
            return new Block(this);
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setArea(Area area) {
            this.area = area;
            return this;
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

    }

    private final int id;
    private final Area area;
    private final String name;

    private Block(Builder builder) {
        id = builder.id;
        area = builder.area;
        name = builder.name;
    }

    public int getId() {
        return id;
    }

    public Area getArea() {
        return area;
    }

    public String getName() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeParcelable(this.area, 0);
        dest.writeString(this.name);
    }

    private Block(Parcel in) {
        this.id = in.readInt();
        this.area = in.readParcelable(Area.class.getClassLoader());
        this.name = in.readString();
    }

    public static Parcelable.Creator<Block> CREATOR = new Parcelable.Creator<Block>() {
        public Block createFromParcel(Parcel source) {
            return new Block(source);
        }

        public Block[] newArray(int size) {
            return new Block[size];
        }
    };
}
