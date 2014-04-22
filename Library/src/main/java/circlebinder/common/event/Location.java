package circlebinder.common.event;

import android.os.Parcel;
import android.os.Parcelable;

public final class Location implements Parcelable {

    public static class Builder {

        private String displayName;
        private String link;

        public Location build() {
            return new Location(this);
        }

        public Builder setDisplayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        public Builder setLink(String link) {
            this.link = link;
            return this;
        }

    }


    private String displayName;
    private String link;

    private Location(Builder builder) {
        displayName = builder.displayName;
        link = builder.link;
    }

    public String getDisplayName() {
        return displayName;
    }

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

    private Location(Parcel in) {
        this.displayName = in.readString();
        this.link = in.readString();
    }

    public static Parcelable.Creator<Location> CREATOR = new Parcelable.Creator<Location>() {
        public Location createFromParcel(Parcel source) {
            return new Location(source);
        }

        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

}
