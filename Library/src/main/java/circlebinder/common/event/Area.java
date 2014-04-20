package circlebinder.common.event;

import android.os.Parcelable;

/**
 * エリア名
 */
public interface Area extends Parcelable {

    String getName();

    String getSimpleName();
}
