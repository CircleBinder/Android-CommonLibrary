package circlebinder.common.eventbus;

public interface BusProvider {

    void post(Object event);

    void register(Object listener);

    void unregister(Object listener);
}
