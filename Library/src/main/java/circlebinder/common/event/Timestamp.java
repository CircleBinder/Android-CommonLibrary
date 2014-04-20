package circlebinder.common.event;

import android.os.Parcelable;

public interface Timestamp extends Parcelable {

    String getDisplayName();

    long getTimestamp();
}
