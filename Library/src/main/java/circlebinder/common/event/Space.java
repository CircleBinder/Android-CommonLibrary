package circlebinder.common.event;

import android.os.Parcel;
import android.os.Parcelable;

public final class Space implements Parcelable {

    public static class Builder implements Parcelable {
        
        private String name;
        private String simpleName;
        private String blockName;
        private int spaceNo;
        private String spaceNoSub;

        public Space build() {
            return new Space(this);
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSimpleName(String simpleName) {
            this.simpleName = simpleName;
            return this;
        }

        public Builder setBlockName(String blockName) {
            this.blockName = blockName;
            return this;
        }

        public Builder setNo(int spaceNo) {
            this.spaceNo = spaceNo;
            return this;
        }

        public Builder setNoSub(String noSub) {
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

        public Builder() {
        }

        private Builder(Parcel in) {
            this.name = in.readString();
            this.simpleName = in.readString();
            this.blockName = in.readString();
            this.spaceNo = in.readInt();
            this.spaceNoSub = in.readString();
        }

        public static Parcelable.Creator<Builder> CREATOR = new Parcelable.Creator<Builder>() {
            public Builder createFromParcel(Parcel source) {
                return new Builder(source);
            }

            public Builder[] newArray(int size) {
                return new Builder[size];
            }
        };

        public void clear() {
            this.name = null;
            this.simpleName = null;
            this.blockName = null;
            this.spaceNo = 0;
            this.spaceNoSub = null;
        }
    }

    private final String name;
    private final String simpleName;
    private final String blockName;
    private final int spaceNo;
    private final String spaceNoSub;

    private Space(Builder builder) {
        name = builder.name;
        simpleName = builder.simpleName;
        blockName = builder.blockName;
        spaceNo = builder.spaceNo;
        spaceNoSub = builder.spaceNoSub;
    }

    public String getName() {
        return name;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public String getBlockName() {
        return blockName;
    }

    public int getNo() {
        return spaceNo;
    }

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

    private Space(Parcel in) {
        this.name = in.readString();
        this.simpleName = in.readString();
        this.blockName = in.readString();
        this.spaceNo = in.readInt();
        this.spaceNoSub = in.readString();
    }

    public static Parcelable.Creator<Space> CREATOR = new Parcelable.Creator<Space>() {
        public Space createFromParcel(Parcel source) {
            return new Space(source);
        }

        public Space[] newArray(int size) {
            return new Space[size];
        }
    };
}
