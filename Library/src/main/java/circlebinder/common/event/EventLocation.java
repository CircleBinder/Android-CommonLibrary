package circlebinder.common.event;

import android.os.Parcelable;

public interface EventLocation extends Parcelable {

    String getDisplayName();

    String getLink();
}
