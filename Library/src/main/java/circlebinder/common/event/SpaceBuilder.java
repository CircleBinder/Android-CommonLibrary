package circlebinder.common.event;

import android.os.Parcel;
import android.os.Parcelable;

public final class SpaceBuilder implements Parcelable {

    private String name;
    private String simpleName;
    private String blockName;
    private int spaceNo;
    private String spaceNoSub;

    public Space build() {
        return new SpaceImpl(this);
    }

    private static class SpaceImpl implements Space, android.os.Parcelable {

        private final String name;
        private final String simpleName;
        private final String blockName;
        private final int spaceNo;
        private final String spaceNoSub;

        public SpaceImpl(SpaceBuilder builder) {
            name = builder.name;
            simpleName = builder.simpleName;
            blockName = builder.blockName;
            spaceNo = builder.spaceNo;
            spaceNoSub = builder.spaceNoSub;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getSimpleName() {
            return simpleName;
        }

        @Override
        public String getBlockName() {
            return blockName;
        }

        @Override
        public int getNo() {
            return spaceNo;
        }

        @Override
        public String getNoSub() {
            return spaceNoSub;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.name);
            dest.writeString(this.simpleName);
            dest.writeString(this.blockName);
            dest.writeInt(this.spaceNo);
            dest.writeString(this.spaceNoSub);
        }

        private SpaceImpl(Parcel in) {
            this.name = in.readString();
            this.simpleName = in.readString();
            this.blockName = in.readString();
            this.spaceNo = in.readInt();
            this.spaceNoSub = in.readString();
        }

        public static Creator<SpaceImpl> CREATOR = new Creator<SpaceImpl>() {
            public SpaceImpl createFromParcel(Parcel source) {
                return new SpaceImpl(source);
            }

            public SpaceImpl[] newArray(int size) {
                return new SpaceImpl[size];
            }
        };
    }

    public SpaceBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public SpaceBuilder setSimpleName(String simpleName) {
        this.simpleName = simpleName;
        return this;
    }

    public SpaceBuilder setBlockName(String blockName) {
        this.blockName = blockName;
        return this;
    }

    public SpaceBuilder setNo(int spaceNo) {
        this.spaceNo = spaceNo;
        return this;
    }

    public SpaceBuilder setNoSub(String noSub) {
        this.spaceNoSub = noSub;
        return this;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.simpleName);
        dest.writeString(this.blockName);
        dest.writeInt(this.spaceNo);
        dest.writeString(this.spaceNoSub);
    }

    public SpaceBuilder() {
    }

    private SpaceBuilder(Parcel in) {
        this.name = in.readString();
        this.simpleName = in.readString();
        this.blockName = in.readString();
        this.spaceNo = in.readInt();
        this.spaceNoSub = in.readString();
    }

    public static Parcelable.Creator<SpaceBuilder> CREATOR = new Parcelable.Creator<SpaceBuilder>() {
        public SpaceBuilder createFromParcel(Parcel source) {
            return new SpaceBuilder(source);
        }

        public SpaceBuilder[] newArray(int size) {
            return new SpaceBuilder[size];
        }
    };
}
