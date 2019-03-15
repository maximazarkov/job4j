package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/*
*  добавление заявок - public Item add(Item item);
*  редактирование заявок - public boolean replace(String id, Item item);
*  удаление заявок - public boolean delete(String id);
*  получение списка всех заявок - public Item[] findAll();
*  получение списка по имени - public Item[] findByName(String key);
*  получение заявки по id - public Item findById(String id);
*  5. На все методы необходимо написать тесты. 
*/

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

	@Test
	public void whenReplaceNameThenReturnNewName() {
		Tracker tracker = new Tracker();
		Item previous = new Item("test1", "testDescription", 123L);
		// Добавляем заявку в трекер. Теперь в объект проинициализирован id.
		tracker.add(previous);
		// Создаем новую заявку.
		Item next = new Item("test2", "testDescription2", 1234L);
		// Проставляем старый id из previous, который был сгенерирован выше.
		next.setId(previous.getId());
		// Обновляем заявку в трекере.
		tracker.replace(previous.getId(), next);
		// Проверяем, что заявка с таким id имеет новые имя test2.
		assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
	}
	
}