package net.ichigotake.circlebinder.common.event;

import android.os.Parcel;

import java.util.Locale;

/**
 * {@link Space} を構築する
 */
public class CircleSpaceBuilder {

    private Block mBlock;
    private int mNo;
    private String mNoSub;

    public Space build() {
        return new CircleSpace(this);
    }

    private static class CircleSpace implements Space, android.os.Parcelable {

        private final Block mBlock;
        private final int mNo;
        private final String mNoSub;

        private CircleSpace(CircleSpaceBuilder builder) {
            mBlock = builder.mBlock;
            mNo = builder.mNo;
            mNoSub = builder.mNoSub;
        }

        @Override
        public String getName() {
            return String.format(Locale.JAPAN, "%s %s-%02d%s",
                    mBlock.getArea().getName(), mBlock.getName(), mNo, mNoSub);
        }

        @Override
        public String getSimpleName() {
            return String.format(Locale.JAPAN, "%s-%02d%s", mBlock.getName(), mNo, mNoSub);
        }

        @Override
        public String getBlockName() {
            return mBlock.getArea().getName();
        }

        @Override
        public int getNo() {
            return mNo;
        }

        @Override
        public String getNoSub() {
            return mNoSub;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(this.mBlock, flags);
            dest.writeInt(this.mNo);
            dest.writeString(this.mNoSub);
        }

        private CircleSpace(Parcel in) {
            this.mBlock = in.readParcelable(Block.class.getClassLoader());
            this.mNo = in.readInt();
            this.mNoSub = in.readString();
        }

        public static Creator<CircleSpace> CREATOR = new Creator<CircleSpace>() {
            public CircleSpace createFromParcel(Parcel source) {
                return new CircleSpace(source);
            }

            public CircleSpace[] newArray(int size) {
                return new CircleSpace[size];
            }
        };
    }

    public CircleSpaceBuilder setBlock(Block block) {
        mBlock = block;
        return this;
    }

    public CircleSpaceBuilder setNo(int no) {
        mNo = no;
        return this;
    }

    public CircleSpaceBuilder setNoSub(String noSub) {
        mNoSub = noSub;
        return this;
    }
}
