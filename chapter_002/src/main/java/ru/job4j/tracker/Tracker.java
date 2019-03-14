package ru.job4j.tracker;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * ������ ��� �������� ������.
     */
    private final Item[] items = new Item[100];

    /**
     * ��������� ������ ��� ����� ������.
     */
    private int position = 0;

    /**
     * ����� ����������� ���������� ������ � ���������.
     * @param item ����� ������
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

	 /**
     * ����� ����������� �������������� ������ � ���������.
	 * @param id ���������� ���� �����.
     * @param item ����� ������.
     */
	public boolean replace(String id, Item item) {
	    //��������� ����������� �����
		return false;
	}
	
	/**
     * ����� ����������� �������� ������ � ���������.
	 * @param id ���������� ���� �����.
     */
	public boolean delete(String id) {
	    //��������� ����������� �����
		return false;
	}
	
	/**
     * ����� ����������� ��������� ������ ���� ������ �� ���������.
	 * @param id ���������� ���� �����.
     */
	public Item[] findAll() {
	    //��������� ����������� �����
		return new Item[];
	}
	
	/**
     * ����� ����������� ��������� ������ �� ����� �� ���������.
	 * @param key - ...
     */
	public Item[] findByName(String key) {
	    //��������� ����������� �����
		return new Item[];
	}
	
	/**
     * ����� ����������� ��������� ������ �� id �� ���������.
	 * @param id - ���������� ���� ������.
     */
	public Item findById(String id) {
	    //��������� ����������� �����
		eturn new Item[];
	}
	
    /**
     * ����� ���������� ���������� ���� ��� ������.
     * ��� ��� � ������ ��� ������������ �����, ����� � ��������. ��� ������������� ��� ����� ���������� ����.
     * @return ���������� ����.
     */
    private String generateId() {
        //����������� ����� ���������.
        return null;
    }
}