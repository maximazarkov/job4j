package ru.job4j.tracker;

import java.util.*;

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
     * ссылка на объект, для генерации случайных чисел.
     */

	private static final Random RN = new Random();
	
    /**
     * Метод реализаущий добавление заявки в хранилище.
	 * @param item новая заявка
	 */
    public void add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
	}

	 /**
     * Метод реализаущий редактирование заявок в хранилище по уникальному ключу.
	 * @param id уникальный ключ заяки.
     * @param item новая заявка.
     */
	public boolean replace(String id, Item item) {
		boolean result = false;
		for (int i = 0; i != position; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                item.setId(id);
                items[i] = item;
                result = true;
                break;
            }
        }
		return result;
	}
	
	/**
     * Метод реализаущий удаление заявок в хранилище.
	 * @param id уникальный ключ заяки.
     */
	public boolean delete(String id) {
		boolean result = false;
		for (int i = 0; i != position; i++) {
			if (items[i] != null && items[i].getId().equals(id)) {
                System.arraycopy(this.items, i + 1, items, i, this.position - i);
				position--;
				result = true;
			}
		}
		return result;
	}
	
	/**
     * Метод реализаущий получение списка всех заявок из хранилища.
	 * @return - all elements by Tracker
     */
	public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
	}

	
	/**
     * Метод реализаущий получение списка по имени из хранилища.
	 * @param key - ...
     */
	public Item[] findByName(String key) {
	    //Требуется реализовать метод
		// думаю, что создавать пустой массив и пересоздавать новый массив - избыточно и расточительно
		// по этому, сначала проверим, есть ли совпадения, а затем создадим новый массив
		//Item[] result = new Item[position];
		int pos = 0;
		for (int i = 0; i != position; i++) {
			pos += this.items[i].getName().equals(key) ? 1 : 0;
		}
		Item[] result = new Item[pos];
		pos = 0;
		for (int i = 0; i != position; i++) {
			if (this.items[i].getName().equals(key)) {
				result[pos++] = this.items[i];
			}
		}
		return result;
	}
	
	/**
     * Метод реализаущий получение заявки по id из хранилища.
	 * @param id - уникальный ключ заявки.
     */
	public Item findById(String id) {
		Item result = null;
		for (Item item : items) {
			if (item != null && item.getId().equals(id)) {
				result = item;
				break;
			}
		}
		return result;
	}
	
    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
		return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}