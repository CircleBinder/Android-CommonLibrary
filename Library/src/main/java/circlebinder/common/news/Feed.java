package circlebinder.common.news;

import android.os.Parcelable;

public interface Feed extends Parcelable {

    String getTitle();

    String getBody();

    FeedDate getPublishDate();

}
