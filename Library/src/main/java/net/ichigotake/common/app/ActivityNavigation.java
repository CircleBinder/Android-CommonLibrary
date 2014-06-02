package net.ichigotake.common.app;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

public final class ActivityNavigation {

    public static boolean hasParentActivity(ActionBarActivity activity) {
        return activity != null && activity.getSupportParentActivityIntent() != null;
    }

    public static boolean onOptionsItemSelected(Activity currentActivity, MenuItem item) {
        if (item.getItemId() != android.R.id.home) {
            return false;
        }

        Intent upIntent = NavUtils.getParentActivityIntent(currentActivity);
        if (upIntent != null) {
            if (NavUtils.shouldUpRecreateTask(currentActivity, upIntent)) {
                TaskStackBuilder.create(currentActivity)
                        .addNextIntentWithParentStack(upIntent)
                        .startActivities();
            } else {
                NavUtils.navigateUpTo(currentActivity, upIntent);
            }
        } else {
            currentActivity.finish();
        }
        return true;
    }
}
