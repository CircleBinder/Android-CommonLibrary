package net.ichigotake.circlebinder.common.event;

import android.os.Parcel;

public class AreaBuilder {

    private String name;
    private String simpleName;

    public Area build() {
        return new AreaImpl(this);
    }

    private static class AreaImpl implements Area, android.os.Parcelable {

        private final String name;
        private final String simpleName;

        private AreaImpl(AreaBuilder builder) {
            name = builder.name;
            simpleName = builder.simpleName;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
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

        private AreaImpl(Parcel in) {
            this.name = in.readString();
            this.simpleName = in.readString();
        }

        public static Creator<AreaImpl> CREATOR = new Creator<AreaImpl>() {
            public AreaImpl createFromParcel(Parcel source) {
                return new AreaImpl(source);
            }

            public AreaImpl[] newArray(int size) {
                return new AreaImpl[size];
            }
        };
    }

    public AreaBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public AreaBuilder setSimpleName(String name) {
        this.simpleName = name;
        return this;
    }

}
