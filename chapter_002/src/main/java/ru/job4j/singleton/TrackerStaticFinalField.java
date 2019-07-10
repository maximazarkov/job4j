package ru.job4j.singleton;

import ru.job4j.tracker.Tracker;

public class TrackerStaticFinalField {
    private static final TrackerStaticFinalField INSTANCE = new TrackerStaticFinalField();

    Tracker tracker = new Tracker();

    private TrackerStaticFinalField() {
    }

    public static TrackerStaticFinalField getInstance() {
        return INSTANCE;
    }
}
