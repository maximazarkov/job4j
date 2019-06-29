package ru.job4j.singleton;

import ru.job4j.tracker.Tracker;

public class TrackerStaticField {
    private static TrackerStaticField instance;

    Tracker tracker = new Tracker();

    private TrackerStaticField() {
    }

    public static TrackerStaticField getInstance() {
        if (instance == null) {
            instance = new TrackerStaticField();
        }
        return instance;
    }
}
