package circlebinder.common.news;

import android.os.Parcel;

public final class FeedBuilder {

    private String title;
    private String body;
    private FeedDate publishDate;

    public Feed build() {
        return new FeedImpl(this);
    }

    private static class FeedImpl implements Feed, android.os.Parcelable {

        private final String title;
        private final String body;
        private final FeedDate publishDate;

        public FeedImpl(FeedBuilder builder) {
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
        public FeedDate getPublishDate() {
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

        private FeedImpl(Parcel in) {
            this.title = in.readString();
            this.body = in.readString();
            this.publishDate = in.readParcelable(FeedDate.class.getClassLoader());
        }

        public static Creator<FeedImpl> CREATOR = new Creator<FeedImpl>() {
            public FeedImpl createFromParcel(Parcel source) {
                return new FeedImpl(source);
            }

            public FeedImpl[] newArray(int size) {
                return new FeedImpl[size];
            }
        };
    }

    public FeedBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public FeedBuilder setBody(String body) {
        this.body = body;
        return this;
    }

    public FeedBuilder setPublishDate(FeedDate publishDate) {
        this.publishDate = publishDate;
        return this;
    }

}
