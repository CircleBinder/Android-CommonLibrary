package circlebinder.common.event;

import android.os.Parcelable;

/**
 * TODO: Transfer(交通手段), TransitTime(駅から会場までの徒歩での移動時間) を用意する
 */
public interface NearbyStation extends Parcelable {

    String getDisplay();
}
