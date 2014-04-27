package circlebinder.common.app;

import android.content.Context;
import android.content.SharedPreferences;

import net.ichigotake.common.content.PreferenceKey;

public final class ViewPagerStateStore {

    private final SharedPreferences preferences;
    private final String KEY_CURRENT_ITEM = "current_item";

    public ViewPagerStateStore(Context context, PreferenceKey key) {
        this.preferences = context.getSharedPreferences(key.getKey(), Context.MODE_PRIVATE);
    }

    public void setCurrentItem(int item) {
        preferences
                .edit()
                .putInt(KEY_CURRENT_ITEM, item)
                .commit();
    }

    public int getItemPosition() {
        return preferences.getInt(KEY_CURRENT_ITEM, 0);
    }
}
