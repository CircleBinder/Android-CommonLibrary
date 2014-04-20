package circlebinder.common.event;

import android.os.Parcelable;

/**
 * ジャンル
 */
public interface Genre extends Parcelable {

    int getId();

    String getName();
}
