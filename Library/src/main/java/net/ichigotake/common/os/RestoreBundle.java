package net.ichigotake.common.os;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;

public final class RestoreBundle {

    private final Bundle arguments;
    private final Bundle savedInstanceState;

    public RestoreBundle(Intent intent, Bundle savedInstanceState) {
        this((intent != null) ? intent.getExtras() : null, savedInstanceState);
    }

    public RestoreBundle(Fragment fragment, Bundle savedInstanceState) {
        this(fragment.getArguments(), savedInstanceState);
    }

    private RestoreBundle(Bundle arguments, Bundle savedInstanceState) {
        this.arguments = (arguments != null) ? arguments : new Bundle();
        this.savedInstanceState = (savedInstanceState != null) ? savedInstanceState : new Bundle();
    }

    public boolean containsKey(String key) {
        return arguments.containsKey(key) || savedInstanceState.containsKey(key);
    }

    public <T extends Parcelable> T getParcelable(String key) {
        T restoreObject;
        if (savedInstanceState.containsKey(key)) {
            restoreObject = savedInstanceState.getParcelable(key);
        } else if (arguments.containsKey(key)) {
            restoreObject = arguments.getParcelable(key);
        } else {
            restoreObject = null;
        }
        return restoreObject;
    }
}
