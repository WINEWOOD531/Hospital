package com.solvd.hospital.observer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class MyObserver {
    private static final Logger LOGGER = LogManager.getLogger(MyObserver.class);
    static List<MyObserver> myObserverList = new ArrayList<>();
    String name;
    String state;

    public MyObserver(String name) {
        this.name = name;
        myObserverList.add(this);
    }

    public void setState(String state) {
        this.state = state;
        notifyAllObservers();
    }

    void notifyAllObservers() {
        for (MyObserver observer : myObserverList) {
            observer.update();
        }
    }

    void update() {
        LOGGER.error(name + " Change status: " + state);
    }
}
