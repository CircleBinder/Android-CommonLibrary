package net.ichigotake.circlebinder.common.event;

import android.os.Parcelable;

import net.ichigotake.circlebinder.common.checklist.Checklist;

public interface Favorite extends Parcelable {

    public Checklist getChecklist();

    public Circle getCircle();
}
