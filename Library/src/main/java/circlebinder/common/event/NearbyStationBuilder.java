package circlebinder.common.event;

import android.os.Parcel;

public final class NearbyStationBuilder {

    private String display;

    public NearbyStation build() {
        return new NearbyStationImpl(this);
    }

    private static class NearbyStationImpl implements NearbyStation, android.os.Parcelable {

        private final String display;

        public NearbyStationImpl(NearbyStationBuilder builder) {
            display = builder.display;
        }

        @Override
        public String getDisplay() {
            return display;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.display);
        }

        private NearbyStationImpl(Parcel in) {
            this.display = in.readString();
        }

        public static Creator<NearbyStationImpl> CREATOR = new Creator<NearbyStationImpl>() {
            public NearbyStationImpl createFromParcel(Parcel source) {
                return new NearbyStationImpl(source);
            }

            public NearbyStationImpl[] newArray(int size) {
                return new NearbyStationImpl[size];
            }
        };
    }

    public NearbyStationBuilder setDisplay(String display) {
        this.display = display;
        return this;
    }
}
