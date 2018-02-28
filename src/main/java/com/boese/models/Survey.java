package com.boese.models;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Survey implements ValueChangeable {
    private List<Option> options = new ArrayList<>();
    private String question;
    private List<Listener> listeners = new ArrayList<>();

    public Survey(String question){
        this.question = question;
    }

    public final String getQuestion() {
        return question;
    }

    public final List<Option> getOptions() {
        return options;
    }

    public void addOption(Option o) {
        options.add(o);
        o.registerListener(this::raiseEvent);
        raiseEvent(o);
        raiseEvent(o, 0);
    }

    public final int getTotalVotes() {
        return options.stream().mapToInt(s -> s.getCount()).sum();
    }


    @Override
    public synchronized void registerListener(Listener listener) {
        if(!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    @Override
    public synchronized void deregisterListener(Listener listener) {
        listeners.remove(listener);
    }

    private void raiseEvent(ValueChangeable sender, Object value) {
        listeners.forEach((e) -> e.raiseEvent(sender, value));
    }

    private void raiseEvent(Object value) {
        int numListener = listeners.size();
        for(int i = 0; i < numListener; i++) {
            listeners.get(i).raiseEvent(this, value);
        }
    }
}
