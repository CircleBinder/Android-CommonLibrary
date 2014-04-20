package net.ichigotake.circlebinder.common.event;

import android.os.Parcelable;

/**
 * マップのブロック
 */
public interface Block extends Parcelable {

    int getId();

    Area getArea();

    String getName();
}
