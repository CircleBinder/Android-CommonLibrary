package circlebinder.common.news;

import android.os.Parcelable;

public interface FeedDate extends Parcelable {

    long getTimestamp();

    String getFormattedDate();
}
