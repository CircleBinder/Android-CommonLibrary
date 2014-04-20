package circlebinder.common.event;

import android.os.Parcel;

public final class TimestampBuilder {

    private long timestamp;
    private String displayName;

    public Timestamp build() {
        return new TimestampImpl(this);
    }

    private static class TimestampImpl implements Timestamp, android.os.Parcelable {

        private final long timestamp;
        private final String displayName;

        public TimestampImpl(TimestampBuilder builder) {
            timestamp = builder.timestamp;
            displayName = builder.displayName;
        }

        @Override
        public long getTimestamp() {
            return timestamp;
        }

        @Override
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

        private TimestampImpl(Parcel in) {
            this.timestamp = in.readLong();
            this.displayName = in.readString();
        }

        public static Creator<TimestampImpl> CREATOR = new Creator<TimestampImpl>() {
            public TimestampImpl createFromParcel(Parcel source) {
                return new TimestampImpl(source);
            }

            public TimestampImpl[] newArray(int size) {
                return new TimestampImpl[size];
            }
        };
    }

    public TimestampBuilder setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public TimestampBuilder setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

}
