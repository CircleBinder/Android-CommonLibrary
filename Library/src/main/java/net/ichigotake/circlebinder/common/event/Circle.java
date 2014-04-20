package net.ichigotake.circlebinder.common.event;

import android.os.Parcelable;

import net.ichigotake.circlebinder.common.checklist.ChecklistColor;

public interface Circle extends Parcelable {

    int getId();

    Space getSpace();

    Genre getGenre();

    ChecklistColor getChecklistColor();

    String getName();

    String getPenName();
}
