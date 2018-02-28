package com.boese.models;

public interface ValueChangeable {
    void registerListener(Listener listener);
    void deregisterListener(Listener listener);
}
