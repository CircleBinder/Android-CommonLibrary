package circlebinder.common.event;

import android.os.Parcel;
import android.os.Parcelable;

public final class CheckItem implements Parcelable {

    public static class Builder {
        //TODO: もう少し具体的な命名
        private int type;

        private int circleId;
        private boolean checked;
        private int price;
        private int num;
        private String name;

        public CheckItem build() {
            return new CheckItem(this);
        }

        public Builder setCircleId(int circleId) {
            this.circleId = circleId;
            return this;
        }

        public Builder setType(int type) {
            this.type = type;
            return this;
        }

        public Builder setChecked(boolean checked) {
            this.checked = checked;
            return this;
        }

        public Builder setPrice(int price) {
            this.price = price;
            return this;
        }

        public Builder setNum(int num) {
            this.num = num;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

    }

    private final int circleId;
    private final int type;
    private final int price;
    private final int num;
    private final boolean checked;
    private final String name;

    private CheckItem(Builder builder) {
        circleId = builder.circleId;
        type = builder.type;
        price = builder.price;
        num = builder.num;
        checked = builder.checked;
        name = builder.name;
    }

    public int getCircleId() {
        return circleId;
    }

    public int getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public int getNum() {
        return num;
    }

    public boolean isChecked() {
        return checked;
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
        dest.writeInt(this.circleId);
        dest.writeInt(this.type);
        dest.writeInt(this.price);
        dest.writeInt(this.num);
        dest.writeByte(checked ? (byte) 1 : (byte) 0);
        dest.writeString(this.name);
    }

    private CheckItem(Parcel in) {
        this.circleId = in.readInt();
        this.type = in.readInt();
        this.price = in.readInt();
        this.num = in.readInt();
        this.checked = in.readByte() != 0;
        this.name = in.readString();
    }

    public static Creator<CheckItem> CREATOR = new Creator<CheckItem>() {
        public CheckItem createFromParcel(Parcel source) {
            return new CheckItem(source);
        }

        public CheckItem[] newArray(int size) {
            return new CheckItem[size];
        }
    };
}
