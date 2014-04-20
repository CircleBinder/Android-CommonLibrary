package net.ichigotake.common.app;

import android.support.v7.app.ActionBarActivity;

public final class ActivityUtils {

    public static boolean hasParentActivity(ActionBarActivity activity) {
        return activity != null && activity.getSupportParentActivityIntent() != null;
    }
}
