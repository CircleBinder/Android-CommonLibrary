package circlebinder.common.news;

import android.os.Parcel;

public final class ChangelogFeedDate implements FeedDate {

    public static class Builder {

        private long timestamp;
        private String formattedDate;

        public ChangelogFeedDate build() {
            return new ChangelogFeedDate(this);
        }

        public Builder setTimestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder setFormattedDate(String formattedDate) {
            this.formattedDate = formattedDate;
            return this;
        }

    }

    private final long timestamp;
    private final String formattedDate;

    private ChangelogFeedDate(Builder builder) {
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

    private ChangelogFeedDate(Parcel in) {
        this.timestamp = in.readLong();
        this.formattedDate = in.readString();
    }

    public static Creator<ChangelogFeedDate> CREATOR = new Creator<ChangelogFeedDate>() {
        public ChangelogFeedDate createFromParcel(Parcel source) {
            return new ChangelogFeedDate(source);
        }

        public ChangelogFeedDate[] newArray(int size) {
            return new ChangelogFeedDate[size];
        }
    };

}
