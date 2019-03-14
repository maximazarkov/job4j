package ru.job4j.tracker;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище.
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

	 /**
     * Метод реализаущий редактирование заявок в хранилище.
	 * @param id уникальный ключ заяки.
     * @param item новая заявка.
     */
	public boolean replace(String id, Item item) {
	    //Требуется реализовать метод
		return false;
	}
	
	/**
     * Метод реализаущий удаление заявок в хранилище.
	 * @param id уникальный ключ заяки.
     */
	public boolean delete(String id) {
	    //Требуется реализовать метод
		return false;
	}
	
	/**
     * Метод реализаущий получение списка всех заявок из хранилища.
	 * @param id уникальный ключ заяки.
     */
	public Item[] findAll() {
	    //Требуется реализовать метод
		return new Item[];
	}
	
	/**
     * Метод реализаущий получение списка по имени из хранилища.
	 * @param key - ...
     */
	public Item[] findByName(String key) {
	    //Требуется реализовать метод
		return new Item[];
	}
	
	/**
     * Метод реализаущий получение заявки по id из хранилища.
	 * @param id - уникальный ключ заявки.
     */
	public Item findById(String id) {
	    //Требуется реализовать метод
		eturn new Item[];
	}
	
    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        //Реализовать метод генерации.
        return null;
    }
}