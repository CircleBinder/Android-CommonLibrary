package circlebinder.common.app;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.view.MenuItem;

public final class UpNavigation {

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
