package net.ichigotake.circlebinder.common.event;

import android.os.Parcel;

import net.ichigotake.circlebinder.common.checklist.Checklist;

public final class FavoriteBuilder {

    private Checklist checklist;
    private Circle circle;

    public Favorite build() {
        return new FavoriteImpl(this);
    }

    private static class FavoriteImpl implements Favorite, android.os.Parcelable {

        private final Checklist checklist;
        private final Circle circle;

        private FavoriteImpl(FavoriteBuilder builder) {
            checklist = builder.checklist;
            circle = builder.circle;
        }

        @Override
        public Checklist getChecklist() {
            return checklist;
        }

        @Override
        public Circle getCircle() {
            return circle;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(this.checklist, 0);
            dest.writeParcelable(this.circle, 0);
        }

        private FavoriteImpl(Parcel in) {
            this.checklist = in.readParcelable(Checklist.class.getClassLoader());
            this.circle = in.readParcelable(Circle.class.getClassLoader());
        }

        public static Creator<FavoriteImpl> CREATOR = new Creator<FavoriteImpl>() {
            public FavoriteImpl createFromParcel(Parcel source) {
                return new FavoriteImpl(source);
            }

            public FavoriteImpl[] newArray(int size) {
                return new FavoriteImpl[size];
            }
        };
    }

    public FavoriteBuilder setCircle(Circle circle) {
        this.circle = circle;
        return this;
    }

    public FavoriteBuilder setChecklist(Checklist checklist) {
        this.checklist = checklist;
        return this;
    }

}
