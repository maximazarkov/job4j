package ru.job4j.singleton;

import org.junit.Test;
import ru.job4j.tracker.Tracker;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class TrackerSingletonTest {

    @Test
    public void whenEnumSingleton() {
        TrackerEnum trackerFirst = TrackerEnum.INSTANCE;
        TrackerEnum trackerSecond = TrackerEnum.INSTANCE;
        assertThat(trackerFirst.toString(), is(trackerSecond.toString()));
    }

    @Test
    public void whenStaticFieldSingleton() {
        TrackerStaticField trackerFirst = TrackerStaticField.getInstance();
        TrackerStaticField trackerSecond = TrackerStaticField.getInstance();
        assertThat(trackerFirst.toString(), is(trackerSecond.toString()));
    }

    @Test
    public void whenStaticFieldFinalSingleton() {
        TrackerStaticFinalField trackerFirst = TrackerStaticFinalField.getInstance();
        TrackerStaticFinalField trackerSecond = TrackerStaticFinalField.getInstance();
        assertThat(trackerFirst.toString(), is(trackerSecond.toString()));
    }

    @Test
    public void whenHolderClassSingleton() {
        TrackerHolderClass trackerFirst = TrackerHolderClass.getInstance();
        TrackerHolderClass trackerSecond = TrackerHolderClass.getInstance();
        assertThat(trackerFirst.toString(), is(trackerSecond.toString()));
    }
}
