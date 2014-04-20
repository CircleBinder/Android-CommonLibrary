package net.ichigotake.circlebinder.common.event;

import android.os.Parcelable;

public interface Space extends Parcelable {

    String getName();

    String getSimpleName();

    String getBlockName();

    int getNo();

    String getNoSub();
}
