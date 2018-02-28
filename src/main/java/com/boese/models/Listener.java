package com.boese.models;

public interface Listener {
    void raiseEvent(ValueChangeable sender, Object value);
}
