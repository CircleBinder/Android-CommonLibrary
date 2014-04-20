package circlebinder.common.circle;

import android.os.Parcel;

public final class CircleDetailIconBuilder {

    private int iconResource;

    public CircleDetailIcon build() {
        return new CircleDetailConImpl(this);
    }

    private final static class CircleDetailConImpl
            implements CircleDetailIcon, android.os.Parcelable {

        private final int iconResource;

        public CircleDetailConImpl(CircleDetailIconBuilder builder) {
            iconResource = builder.iconResource;
        }

        @Override
        public int getIconResource() {
            return iconResource;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.iconResource);
        }

        private CircleDetailConImpl(Parcel in) {
            this.iconResource = in.readInt();
        }

        public static Creator<CircleDetailConImpl> CREATOR = new Creator<CircleDetailConImpl>() {
            public CircleDetailConImpl createFromParcel(Parcel source) {
                return new CircleDetailConImpl(source);
            }

            public CircleDetailConImpl[] newArray(int size) {
                return new CircleDetailConImpl[size];
            }
        };
    }

    public CircleDetailIconBuilder setIconResource(int iconResource) {
        this.iconResource = iconResource;
        return this;
    }
}
