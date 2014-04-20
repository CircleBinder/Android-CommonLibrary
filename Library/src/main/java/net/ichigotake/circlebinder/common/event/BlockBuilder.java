package net.ichigotake.circlebinder.common.event;

import android.os.Parcel;

public final class BlockBuilder {

    private int id;
    private Area area;

    private String name;

    public Block build() {
        return new BlockImpl(this);
    }

    private static class BlockImpl implements Block, android.os.Parcelable {

        private final int id;
        private final Area area;
        private final String name;

        private BlockImpl(BlockBuilder builder) {
            id = builder.id;
            area = builder.area;
            name = builder.name;
        }

        @Override
        public int getId() {
            return id;
        }

        @Override
        public Area getArea() {
            return area;
        }

        @Override
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

        private BlockImpl(Parcel in) {
            this.id = in.readInt();
            this.area = in.readParcelable(Area.class.getClassLoader());
            this.name = in.readString();
        }

        public static Creator<BlockImpl> CREATOR = new Creator<BlockImpl>() {
            public BlockImpl createFromParcel(Parcel source) {
                return new BlockImpl(source);
            }

            public BlockImpl[] newArray(int size) {
                return new BlockImpl[size];
            }
        };
    }

    public BlockBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public BlockBuilder setArea(Area area) {
        this.area = area;
        return this;
    }

    public BlockBuilder setId(int id) {
        this.id = id;
        return this;
    }

}
