package ru.job4j.singleton;

import ru.job4j.tracker.Tracker;

public class TrackerHolderClass {

    Tracker tracker = new Tracker();

    private TrackerHolderClass() {
    }

    public static TrackerHolderClass getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerHolderClass INSTANCE = new TrackerHolderClass();
    }
}
