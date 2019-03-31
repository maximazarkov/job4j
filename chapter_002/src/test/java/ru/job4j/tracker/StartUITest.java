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

    public final static String LS = System.lineSeparator();
    public final static String MENU = new StringBuilder()
        .append("0. Add new Item").append(LS)
        .append("1. Show all items").append(LS)
        .append("2. Edit item").append(LS)
        .append("3. Delete item").append(LS)
        .append("4. Find item by Id").append(LS)
        .append("5. Find items by name").append(LS)
        .append("6. Exit Program").toString();


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
        Tracker tracker = new Tracker();     // создаём Tracker
        Item item = new Item("a", "a", 123L);
        tracker.add(item);
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker);
        StringBuilder sb = new StringBuilder();
        sb.append(MENU).append(LS);
        sb.append("------------ Отображение всех заявки --------------").append(LS);
        sb.append(String.format("Item{id='%S', name='%s', desc='%s', time=%s}",
                item.getId(),
                item.getName(),
                item.getDesc(),
                item.getTime())).append(LS);
        sb.append("---------------------------------------------------").append(LS);
        sb.append(MENU).append(LS);
        //assertThat(new String(out.toByteArray()), is(sb.toString()));
        assertThat(out.toString(), is(sb.toString()));
    }

    @Test
    public void whenFindItemsById() {
        Tracker tracker = new Tracker();
        Item item = new Item("a", "a", 123L);
        tracker.add(item);
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker);
        StringBuilder sb = new StringBuilder();
        sb.append(MENU).append(LS);
        sb.append("---------------- Поиск заявки по Id ---------------").append(LS);
        sb.append(String.format("Item{id='%S', name='%s', desc='%s', time=%s}",
                item.getId(),
                item.getName(),
                item.getDesc(),
                item.getTime())).append(LS);
        sb.append("---------------------------------------------------").append(LS);
        sb.append(MENU).append(LS);
        //assertThat(new String(out.toByteArray()), is(sb.toString()));
        assertThat(out.toString(), is(sb.toString()));
    }

    @Test
    public void whenFindItemsByName() {
        Tracker tracker = new Tracker();
        Item item = new Item("a", "a", 123L);
        tracker.add(item);
        Input input = new StubInput(new String[]{"5", "a", "6"});
        new StartUI(input, tracker);
        StringBuilder sb = new StringBuilder();
        sb.append(MENU).append(LS);
        sb.append("-------------- Поиск заявки по имени --------------").append(LS);
        sb.append(String.format("Item{id='%S', name='%s', desc='%s', time=%s}",
                item.getId(),
                item.getName(),
                item.getDesc(),
                item.getTime())).append(LS);
        sb.append("---------------------------------------------------").append(LS);
        sb.append(MENU).append(LS);
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
