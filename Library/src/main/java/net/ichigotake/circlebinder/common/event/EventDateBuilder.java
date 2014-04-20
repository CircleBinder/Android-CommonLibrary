package net.ichigotake.circlebinder.common.event;

import android.os.Parcel;

public final class EventDateBuilder {

    private String name;

    public EventDate build() {
        return new EventDateImpl(this);
    }

    private static class EventDateImpl implements EventDate, android.os.Parcelable {

        private final String name;

        public EventDateImpl(EventDateBuilder builder) {
            name = builder.name;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.name);
        }

        private EventDateImpl(Parcel in) {
            this.name = in.readString();
        }

        public static Creator<EventDateImpl> CREATOR = new Creator<EventDateImpl>() {
            public EventDateImpl createFromParcel(Parcel source) {
                return new EventDateImpl(source);
            }

            public EventDateImpl[] newArray(int size) {
                return new EventDateImpl[size];
            }
        };
    }

    public EventDateBuilder setName(String name) {
        this.name = name;
        return this;
    }
}
