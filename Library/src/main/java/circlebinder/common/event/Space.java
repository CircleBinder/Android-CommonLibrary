package circlebinder.common.event;

import android.os.Parcel;
import android.os.Parcelable;

public class Space implements Parcelable {

    private final String name;
    private final String simpleName;
    private final String blockName;
    private final int spaceNo;
    private final String spaceNoSub;

    Space(SpaceBuilder builder) {
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
