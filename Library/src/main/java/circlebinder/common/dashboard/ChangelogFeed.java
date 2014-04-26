package circlebinder.common.dashboard;

import android.os.Parcel;
import android.os.Parcelable;

public final class ChangelogFeed implements Feed, Parcelable {

    public static class Builder {

        private String title;
        private String body;
        private PublishDate publishDate;

        public ChangelogFeed build() {
            return new ChangelogFeed(this);
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setBody(String body) {
            this.body = body;
            return this;
        }

        public Builder setPublishDate(PublishDate publishDate) {
            this.publishDate = publishDate;
            return this;
        }

    }

    private final String title;
    private final String body;
    private final PublishDate publishDate;

    public ChangelogFeed(Builder builder) {
        this.title = builder.title;
        this.body = builder.body;
        this.publishDate = builder.publishDate;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getBody() {
        return body;
    }

    @Override
    public PublishDate getPublishDate() {
        return publishDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.body);
        dest.writeParcelable(this.publishDate, flags);
    }

    private ChangelogFeed(Parcel in) {
        this.title = in.readString();
        this.body = in.readString();
        this.publishDate = in.readParcelable(PublishDate.class.getClassLoader());
    }

    public static Creator<ChangelogFeed> CREATOR = new Creator<ChangelogFeed>() {
        public ChangelogFeed createFromParcel(Parcel source) {
            return new ChangelogFeed(source);
        }

        public ChangelogFeed[] newArray(int size) {
            return new ChangelogFeed[size];
        }
    };
}
