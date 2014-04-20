package circlebinder.common.event;

import android.os.Parcel;

public final class EventBuilder {

    private String name;
    private EventLocation location;
    private EventDate date;

    public Event build() {
        return new EventImpl(this);
    }

    private static class EventImpl implements Event, android.os.Parcelable {

        private final String name;
        private final EventLocation location;
        private final EventDate date;

        private EventImpl(EventBuilder builder) {
            name = builder.name;
            location = builder.location;
            date = builder.date;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public EventLocation getLocation() {
            return location;
        }

        @Override
        public EventDate getDate() {
            return date;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.name);
            dest.writeParcelable(this.location, 0);
            dest.writeParcelable(this.date, 0);
        }

        private EventImpl(Parcel in) {
            this.name = in.readString();
            this.location = in.readParcelable(EventLocation.class.getClassLoader());
            this.date = in.readParcelable(EventDate.class.getClass().getClassLoader());
        }

        public static Creator<EventImpl> CREATOR = new Creator<EventImpl>() {
            public EventImpl createFromParcel(Parcel source) {
                return new EventImpl(source);
            }

            public EventImpl[] newArray(int size) {
                return new EventImpl[size];
            }
        };
    }

    public EventBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public EventBuilder setLocation(EventLocation location) {
        this.location = location;
        return this;
    }

    public EventBuilder setDate(EventDate date) {
        this.date = date;
        return this;
    }

}
