package circlebinder.common.search;

import android.content.Context;
import android.content.SharedPreferences;

import net.ichigotake.common.content.PreferenceKey;

public final class CircleSearchOptionStore {

    private final SharedPreferences pref;

    public CircleSearchOptionStore(Context context, PreferenceKey key) {
        pref = context.getSharedPreferences(
                key.getKey(),
                Context.MODE_PRIVATE
        );
    }

    public void save(CircleSearchOption option) {
        pref.edit()
                .putString(Key.ORDER.name(), option.getOrder().getSequence().toString())
                .putString(Key.KEYWORD.name(), option.getKeyword().toString())
                .commit();
    }

    public CircleSearchOption get() {
        return new CircleSearchOption.Builder()
                .setKeyword(pref.getString(Key.KEYWORD.name(), null))
                .setOrder(Comic1CircleOrder.get(pref.getString(Key.ORDER.name(), null)))
                .build();
    }

    private static enum Key {
        ORDER,
        KEYWORD,
        ;
    }
}
