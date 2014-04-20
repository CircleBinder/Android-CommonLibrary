package circlebinder.common.event;

import android.os.Parcel;

public final class EventLocationBuilder {

    private String displayName;
    private String link;

    public EventLocation build() {
        return new EventLocationImpl(this);
    }

    private static class EventLocationImpl implements EventLocation, android.os.Parcelable {

        private String displayName;
        private String link;

        public EventLocationImpl(EventLocationBuilder builder) {
            displayName = builder.displayName;
            link = builder.link;
        }

        @Override
        public String getDisplayName() {
            return displayName;
        }

        @Override
        public String getLink() {
            return link;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.displayName);
            dest.writeString(this.link);
        }

        private EventLocationImpl(Parcel in) {
            this.displayName = in.readString();
            this.link = in.readString();
        }

        public static Creator<EventLocationImpl> CREATOR = new Creator<EventLocationImpl>() {
            public EventLocationImpl createFromParcel(Parcel source) {
                return new EventLocationImpl(source);
            }

            public EventLocationImpl[] newArray(int size) {
                return new EventLocationImpl[size];
            }
        };
    }

    public EventLocationBuilder setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public EventLocationBuilder setLink(String link) {
        this.link = link;
        return this;
    }

}
