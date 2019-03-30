package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    // сохраним дефолный вывод на консоль, чтобы потом к нему вернуться
    private final PrintStream stdout = System.out;

    // создадим буфер для результата
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    public static StringBuilder menu = new StringBuilder();

    @Before
    public void loadOutputBefore() {
        System.out.println("execute Before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutputAfter() {
        System.setOut(this.stdout);
        System.out.println("execute After method");
    }


    @Test
    public void whenShowAllItems() {

        menu.append("0. Add new Item");
        menu.append(System.lineSeparator());
        menu.append("1. Show all items");
        menu.append(System.lineSeparator());
        menu.append("2. Edit item");
        menu.append(System.lineSeparator());
        menu.append("3. Delete item");
        menu.append(System.lineSeparator());
        menu.append("4. Find item by Id");
        menu.append(System.lineSeparator());
        menu.append("5. Find items by name");
        menu.append(System.lineSeparator());
        menu.append("6. Exit Program");

        Tracker tracker = new Tracker();     // создаём Tracker
        Item item = new Item("a", "a", 123L);
        tracker.add(item);
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"1", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker);
        StringBuilder sb = new StringBuilder();
        sb.append(menu.toString());
        sb.append(System.lineSeparator());
        sb.append("------------ Отображение всех заявки --------------");
        sb.append(System.lineSeparator());
        sb.append("date\\t\\t\\t[id]\\t\\t\\tname::desc");
        sb.append(System.lineSeparator());
        sb.append("123\\t[" + item.getId() + "]\\ta::a");
        sb.append(System.lineSeparator());
        sb.append("-----------\\tВсего найдено заявок: 1");
        sb.append(System.lineSeparator());
        sb.append("---------------------------------------------------");
        sb.append(System.lineSeparator());
        sb.append(menu.toString());
        sb.append(System.lineSeparator());
        //assertThat(new String(out.toByteArray()), is(sb.toString()));
        assertThat(out.toString(), is(sb.toString()));

    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker);     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = new Item("test name", "desc", System.currentTimeMillis());
        tracker.add(item);
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker);
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThenNull() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = new Item("test name", "desc", System.currentTimeMillis());
        tracker.add(item);
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker);
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        Item delItem = null;
        assertThat(tracker.findById(item.getId()), is(delItem));
    }
}
