package com.boese.models;

import java.util.ArrayList;
import java.util.List;

public class Option implements ValueChangeable {
    private String text;
    private int count;

    private List<Listener> listeners = new ArrayList<Listener>();

    public Option(String text) {
        this.text = text;
    }

    public synchronized void increaseCount() {
        count++;
        raiseEvent(count);
    }

    public synchronized int getCount() {
        return count;
    }

    public synchronized void setCount(int count) {
        this.count = count;
        raiseEvent(count);
    }

    public String getText() {
        return text;
    }

    public synchronized void registerListener(Listener listener) {
        if(!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    public synchronized void deregisterListener(Listener listener) {
        listeners.remove(listener);
    }

    private void raiseEvent(int value) {
        listeners.stream().forEach((e) -> e.raiseEvent(this, value));
    }
}
