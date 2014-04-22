package circlebinder.common.event;

import android.os.Parcel;
import android.os.Parcelable;

import circlebinder.common.checklist.Checklist;

public final class Favorite implements Parcelable {

    public static class Builder {

        private Checklist checklist;
        private Circle circle;

        public Favorite build() {
            return new Favorite(this);
        }

        public Builder setCircle(Circle circle) {
            this.circle = circle;
            return this;
        }

        public Builder setChecklist(Checklist checklist) {
            this.checklist = checklist;
            return this;
        }

    }

    private final Checklist checklist;
    private final Circle circle;

    private Favorite(Builder builder) {
        checklist = builder.checklist;
        circle = builder.circle;
    }

    public Checklist getChecklist() {
        return checklist;
    }

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

    private Favorite(Parcel in) {
        this.checklist = in.readParcelable(Checklist.class.getClassLoader());
        this.circle = in.readParcelable(Circle.class.getClassLoader());
    }

    public static Parcelable.Creator<Favorite> CREATOR = new Parcelable.Creator<Favorite>() {
        public Favorite createFromParcel(Parcel source) {
            return new Favorite(source);
        }

        public Favorite[] newArray(int size) {
            return new Favorite[size];
        }
    };
}
