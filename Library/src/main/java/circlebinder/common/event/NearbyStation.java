package circlebinder.common.event;

import android.os.Parcel;
import android.os.Parcelable;

public final class NearbyStation implements Parcelable {

    public static class Builder {

        private String display;

        public NearbyStation build() {
            return new NearbyStation(this);
        }

        public Builder setDisplay(String display) {
            this.display = display;
            return this;
        }
    }

    private final String display;

    private NearbyStation(Builder builder) {
        display = builder.display;
    }

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

    private NearbyStation(Parcel in) {
        this.display = in.readString();
    }

    public static Creator<NearbyStation> CREATOR = new Creator<NearbyStation>() {
        public NearbyStation createFromParcel(Parcel source) {
            return new NearbyStation(source);
        }

        public NearbyStation[] newArray(int size) {
            return new NearbyStation[size];
        }
    };
}
