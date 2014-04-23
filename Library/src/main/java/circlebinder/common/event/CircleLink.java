package circlebinder.common.event;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public final class CircleLink implements Parcelable {

    public static class Builder {
        private Uri uri;
        private int iconResource;

        public CircleLink build() {
            return new CircleLink(this);
        }

        public Builder setUri(Uri uri) {
            this.uri = uri;
            return this;
        }

        public Builder setIcon(int iconResource) {
            this.iconResource = iconResource;
            return this;
        }
    }

    private final Uri uri;
    private final int iconResource;

    private CircleLink(Builder builder) {
        uri = builder.uri;
        iconResource = builder.iconResource;
    }

    public Uri getUri() {
        return uri;
    }

    public int getIconResource() {
        return iconResource;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.uri, 0);
        dest.writeInt(this.iconResource);
    }

    private CircleLink(Parcel in) {
        this.uri = in.readParcelable(Uri.class.getClassLoader());
        this.iconResource = in.readInt();
    }

    public static Creator<CircleLink> CREATOR = new Creator<CircleLink>() {
        public CircleLink createFromParcel(Parcel source) {
            return new CircleLink(source);
        }

        public CircleLink[] newArray(int size) {
            return new CircleLink[size];
        }
    };
}
