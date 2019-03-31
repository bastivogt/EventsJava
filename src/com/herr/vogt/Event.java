package com.herr.vogt;

public class Event {

    protected Object source;

    public Event(Object source) {
        this.source = source;
    }

    public Object getSource() {
        return source;
    }
}
