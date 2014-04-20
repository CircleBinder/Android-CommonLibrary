package circlebinder.common.event;

import android.os.Parcelable;

public interface Event extends Parcelable {

    String getName();

    EventLocation getLocation();

    EventDate getDate();
}
