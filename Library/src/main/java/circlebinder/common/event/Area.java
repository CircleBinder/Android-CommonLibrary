package circlebinder.common.event;

import android.os.Parcel;
import android.os.Parcelable;

public final class Area implements Parcelable {
    
    public static class Builder {

        private String name;
        private String simpleName;

        public Area build() {
            return new Area(this);
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSimpleName(String name) {
            this.simpleName = name;
            return this;
        }

    }

    private final String name;
    private final String simpleName;

    private Area(Builder builder) {
        name = builder.name;
        simpleName = builder.simpleName;
    }

    public String getName() {
        return name;
    }

    public String getSimpleName() {
        return simpleName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.simpleName);
    }

    private Area(Parcel in) {
        this.name = in.readString();
        this.simpleName = in.readString();
    }

    public static Creator<Area> CREATOR = new Creator<Area>() {
        public Area createFromParcel(Parcel source) {
            return new Area(source);
        }

        public Area[] newArray(int size) {
            return new Area[size];
        }
    };
}
