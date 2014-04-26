package circlebinder.common.dashboard;

import android.os.Parcel;
import android.os.Parcelable;

public final class PublishDate implements FeedDate, Parcelable {

    public final static class Builder {
        //TODO: デフォルトのフォーマットを考えておく
        private long timestampMillSeconds;
        private String formattedDate;

        public PublishDate build() {
            return new PublishDate(this);
        }

        public Builder setTimestamp(long millSeconds) {
            this.timestampMillSeconds = millSeconds;
            return this;
        }

        public Builder setFormattedDate(String formattedDate) {
            this.formattedDate = formattedDate;
            return this;
        }
    }

    private final long timestampMillSeconds;
    private final String formattedDate;

    private PublishDate(Builder builder) {
        this.timestampMillSeconds = builder.timestampMillSeconds;
        this.formattedDate = builder.formattedDate;
    }

    @Override
    public long getTimestamp() {
        return timestampMillSeconds;
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
        dest.writeLong(this.timestampMillSeconds);
        dest.writeString(this.formattedDate);
    }

    private PublishDate(Parcel in) {
        this.timestampMillSeconds = in.readLong();
        this.formattedDate = in.readString();
    }

    public static Creator<PublishDate> CREATOR = new Creator<PublishDate>() {
        public PublishDate createFromParcel(Parcel source) {
            return new PublishDate(source);
        }

        public PublishDate[] newArray(int size) {
            return new PublishDate[size];
        }
    };
}
