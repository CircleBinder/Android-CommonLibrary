package net.ichigotake.common.app;

public interface TripCreator<T> {

    Tripper create(T item);
}
