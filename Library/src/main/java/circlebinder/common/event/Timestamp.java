package circlebinder.common.event;

import android.os.Parcel;
import android.os.Parcelable;

public final class Timestamp implements Parcelable {

    public static class Builder {

        private long timestamp;
        private String displayName;

        public Timestamp build() {
            return new Timestamp(this);
        }

        public Builder setTimestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder setDisplayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

    }

    private final long timestamp;
    private final String displayName;

    private Timestamp(Builder builder) {
        timestamp = builder.timestamp;
        displayName = builder.displayName;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.timestamp);
        dest.writeString(this.displayName);
    }

    private Timestamp(Parcel in) {
        this.timestamp = in.readLong();
        this.displayName = in.readString();
    }

    public static Creator<Timestamp> CREATOR = new Creator<Timestamp>() {
        public Timestamp createFromParcel(Parcel source) {
            return new Timestamp(source);
        }

        public Timestamp[] newArray(int size) {
            return new Timestamp[size];
        }
    };
}
