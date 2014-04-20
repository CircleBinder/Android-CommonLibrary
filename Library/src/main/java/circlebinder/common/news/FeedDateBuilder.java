package circlebinder.common.news;

import android.os.Parcel;

public final class FeedDateBuilder {

    private long timestamp;
    private String formattedDate;

    public FeedDate build() {
        return new FeedDateImpl(this);
    }

    private static class FeedDateImpl implements FeedDate, android.os.Parcelable {

        private final long timestamp;
        private final String formattedDate;

        public FeedDateImpl(FeedDateBuilder builder) {
            this.timestamp = builder.timestamp;
            this.formattedDate = builder.formattedDate;
        }

        @Override
        public long getTimestamp() {
            return timestamp;
        }

        @Override
        public String getFormattedDate() {
            return formattedDate;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeLong(this.timestamp);
            dest.writeString(this.formattedDate);
        }

        private FeedDateImpl(Parcel in) {
            this.timestamp = in.readLong();
            this.formattedDate = in.readString();
        }

        public static Creator<FeedDateImpl> CREATOR = new Creator<FeedDateImpl>() {
            public FeedDateImpl createFromParcel(Parcel source) {
                return new FeedDateImpl(source);
            }

            public FeedDateImpl[] newArray(int size) {
                return new FeedDateImpl[size];
            }
        };
    }

    public FeedDateBuilder setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public FeedDateBuilder setFormattedDate(String formattedDate) {
        this.formattedDate = formattedDate;
        return this;
    }

}
