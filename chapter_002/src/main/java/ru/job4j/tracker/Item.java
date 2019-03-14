package ru.job4j.tracker;

import java.util.Objects;

/**
*@author Azarkov Maxim
*@version $Id$.
*@since 0.1
*/
public class Item{
	private String id;
	private String name;
	private String desc;
	private long time;
	
	/**
	*�����������. ������ ������� ���� Item - ������.
	*@param name - ��� ������.
	*@param des� - �������� ������.
	*@param time - ����� �������� ������.
	*@since 0.1.
	*/
	public Item(String name, String desc, long time) {
		this.name = name;
		this.desc = desc;
		this.time = time;
	}
	
	/**
	�*setId - ��������� �������� ����������� ����� ������. ���������� ���� ������ - id �������� ������� Item. ������������ � ������� hash-�������.
	*@param id - �������� ����������� ����� ������ ���� String.
	*@since 0.1.
	*/
	public void setId(String id) {
		this.id = id;
	}

	/**
	*getId - ���������� ����������� ����� ������.
	*@retern �������� ����������� ����� ������
	*@since 0.1
	*/
	public String getId() {
		return this.id;
	}
	
	/**
	*setName - ��������� �������� ������.
	*@param name - �������� �������� ������ ���� String.
	*@since 0.1
	*/
	public void setName(String name){
		this.name = name;
	}
	
	/**
	*getId - ���������� �������� ������.
	*@retern �������� �������� ������ ���� String.
	*@since 0.1.
	*/
	public String getName(){
		return this.name;
	}

	/**
	*setDesc - ��������� �������� ������.
	*@param desc - �������� �������� �������� ������ ���� String.
	*@since 0.1.
	*/
	public void setDesc(String desc){
		this.desc = desc;
	}
	
	/**
	*getDesc - ���������� �������� ������.
	*@retern �������� �������� ������ ���� String.
	*@since 0.1.
	*/
	public String getDesc(){
		return this.desc;
	}
	
	/**
	*setTime - ��������� ����� �������� ������.
	*@param desc - �������� ������� �������� ������ ���� long.
	*@since 0.1.
	*/
	public void setTime(long time){
		this.time = time;
	}

	/**
	*getTime - ���������� ����� �������� ������.
	*@retern �������� ������� �������� ������ ���� long.
	*@since 0.1.
	*/
	public long getTime(){
		return this.time;
	}
	
	/////////////////////////////
	// ���� �� ��������� �������
	/////////////////////////////
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Item item = (Item) o;
		return time == item.time &&
				Objects.equals(id, item.id) &&
				Objects.equals(name, item.name) &&
				Objects.equals(desc, item.desc);
	}
	
	/////////////////////////////
	// ���� �� ��������� �������
	/////////////////////////////
	@Override
	public int hashCode() {
		return Objects.hash(id, name, desc, time);
	}
}