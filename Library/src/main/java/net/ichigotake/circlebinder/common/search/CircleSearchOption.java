package net.ichigotake.circlebinder.common.search;

import android.os.Parcel;
import android.os.Parcelable;

public final class CircleSearchOption implements Parcelable {

    private final String keyword;
    private final Order order;

    private CircleSearchOption(Builder builder) {
        keyword = builder.keyword;
        order = builder.order;
    }

    public final static class Builder {

        private String keyword;
        private Order order = new DefaultOrder();

        public CircleSearchOption build() {
            return new CircleSearchOption(this);
        }


        public Builder setKeyword(String keyword) {
            this.keyword = keyword;
            return this;
        }

        public Builder setOrder(Order order) {
            this.order = order;
            return this;
        }
    }

    public Order getOrder() {
        return order;
    }

    public boolean hasKeyword() {
        return keyword != null;
    }

    public CharSequence getKeyword() {
        return keyword;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.keyword);
        dest.writeSerializable(this.order);
    }

    private CircleSearchOption(Parcel in) {
        this.keyword = in.readString();
        this.order = (Order)in.readSerializable();
    }

    public static Creator<CircleSearchOption> CREATOR = new Creator<CircleSearchOption>() {
        public CircleSearchOption createFromParcel(Parcel source) {
            return new CircleSearchOption(source);
        }

        public CircleSearchOption[] newArray(int size) {
            return new CircleSearchOption[size];
        }
    };
}
