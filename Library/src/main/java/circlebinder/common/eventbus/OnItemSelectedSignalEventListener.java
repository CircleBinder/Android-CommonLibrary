package circlebinder.common.eventbus;

import net.ichigotake.common.widget.OnItemSelectedEventListener;

public final class OnItemSelectedSignalEventListener<T> implements OnItemSelectedEventListener<T> {

    private final BusSignal signal;

    public OnItemSelectedSignalEventListener(BusSignal signal) {
        this.signal = signal;
    }

    @Override
    public void onItemSelected(T item) {
        signal.post(item);
    }

    @Override
    public void onNothingSelected() {
        signal.post(new NothingSelectedEvent());
    }
}
