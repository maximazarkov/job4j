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
		boolean result = false;
		for (Item itm : items) {
			if (itm != null && itm.getId().equals(id)) {
				itm = item;
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
	    //Требуется реализовать метод
		//System.arraycopy (sourceArr, 5, destArr, 0, 5);
		
/*
    public String[] remove(String[] array) {
        //После удаления дубликатов в массиве {"Привет", "Мир", "Привет", "Супер", "Мир"} должно получиться {"Привет", "Мир", "Супер"}
        int numDupl = 0; // количество дуплекатов
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])) {
                    String temp = array[array.length - numDupl - 1];
                    array[array.length - numDupl - 1] = array[j];
                    array[j] = temp;
                    numDupl++;
                }
                if (j >= array.length - numDupl - 1) {
                    break;
                }
            }
        }
        return Arrays.copyOf(array, numDupl + 1);
    }
*/
		boolean result = false;
		
		for (int i = 0; i != position; i++) {
			if (items[i] != null && items[i].getId().equals(id)) {
				System.arraycopy(this.items, this.position - i, items, i, this.position - i - 1);
				result = true;
			}
		}
		return result;
	}
	
	/**
     * Метод реализаущий получение списка всех заявок из хранилища.
	 * @param id уникальный ключ заяки.
     */
	public Item[] findAll() {
		Item[]  result = new Item[position];
		for (int i = 0; i != position; i++) {
				result[i] = this.items[i];
		}
		return result;
	}
	
	/**
     * Метод реализаущий получение списка по имени из хранилища.
	 * @param key - ...
     */
	public Item[] findByName(String key) {
	    //Требуется реализовать метод
		Item[] result = new Item[position];
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