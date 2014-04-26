package circlebinder.common.eventbus;

import android.util.Log;

import com.squareup.otto.Bus;

public final class EventBus {

    private static final String LOG_TAG = EventBus.class.getSimpleName();

    public static interface Signal {
        public void post(Object event);
    }

    public static EventBus create(Object listener) {
        EventBus eventBus =  new EventBus();
        eventBus.register(listener);
        return eventBus;
    }

    public static void eventPost(Object signal, Object event) {
        if (signal instanceof Signal) {
            ((Signal)signal).post(event);
        } else {
            Log.d(LOG_TAG,
                    "Can't post event: Not contain `Signal` on " + signal.getClass().getSimpleName());
        }
    }

    private final Bus eventBus;

    public EventBus() {
        eventBus = new Bus();
    }

    public void post(Object event) {
        eventBus.post(event);
    }

    public void register(Object listener) {
        eventBus.register(listener);
    }

    public void unregister(Object listener) {
        eventBus.register(listener);
    }

    @Override
    public String toString() {
        return eventBus.toString();
    }
}
