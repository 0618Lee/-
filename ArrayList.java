package com.JL;

@SuppressWarnings("unchecked")
public class ArrayList<T> {
	//数组
	private T[] elements;
	//动态数组当前存储的元素个数
	private int size;
	private static final int DEFAULT_CAPACITY = 10;
	private static final int ELEMENT_NOT_FOUND = -1;
	
	/*	index检查是否合理	*/
	private void IndexCheck(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index:" + index + ",Size:" + size);
		}
	}
	
	/*	如果缩容和扩容时机相乘等于1时，会产生缩容扩容震荡	*/
	/*	确保最大容量能放入所有元素	*/
	private void ensureCapacity(int capacity) {
		int oldcapacity  = elements.length;
		if(oldcapacity >= capacity) return;
		//新容量为原来的1.5倍
		int newCapacity = oldcapacity + (oldcapacity >> 1);
		T[] newElements = (T[]) new Object[newCapacity];
		for(int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		System.out.println(oldcapacity + "扩容为：" + newCapacity);
	}
	
	//有参构造函数
	public ArrayList(int capacity) {
		capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
		elements = (T[]) new Object[capacity];
	}
	
	//无参构造函数
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	/* 清空数组	*/
	public void clear() {
		for(int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}
	
	/*	加入元素	*/
	public void add(T element) {
		add(size, element);
	}
	
	/*	在指定位置加入element	*/
	public void add(int index, T element) {
//		if(element == null) return,控制不能存储null。但一般来说，对象可以存储null;
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index:" + index + ",Size:" + size);
		}
		ensureCapacity(size + 1); 
		for(int i = size;i > index; i--) {
			elements[i] = elements[i - 1];
		}
		elements[index] = element;
		size++;
	}
	
	/*	移除指定位置的元素	*/
	public T remove(int index) { 
		IndexCheck(index);
		T old = elements[index];
		for(int i = index + 1;i < size; i++) {
			elements[i - 1] = elements[i];
		}
		elements[--size] = null;
		trim();
		return old;
	}
	
	public void remove(T element) {
		remove(indexOf(element));
	}
	
	/*	缩容	*/
	private void trim() {
		int capacity = elements.length;
		if(size >= (capacity >> 1) || capacity <= 10)	return;

		//容量很大
		int newCapacity = capacity >> 1;
		T[] newElements = (T[]) new Object[newCapacity];
		for(int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		System.out.println(capacity + "缩容为：" + newCapacity);
	}
	
	/*	当前数组的元素个数	*/
	public int size() {
		return size;
	}
	
	/*	检查数组是否为空		*/
	public boolean isEmpty() {
		return size == 0;
	}
	
	/*	获取指定位置的元素	*/
	public T get(int index) {
		IndexCheck(index);
		return elements[index];
	}
	
	/*	把指定位置的元素修改成element，并且返回旧值	*/
	public T set(int index, T element) {
		IndexCheck(index);
		T old = elements[index];
		elements[index] = element;
		return old;
	}
	
	/* 检查数组是否包含某个元素	*/
	public boolean contains(T element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}
	
	/* 检查element在数组的具体位置	*/
	public int indexOf(T element) {
		if(element == null) {
			for(int i = 0; i < size; i++) {
				if(elements[i] == null)	return i;
			}
		}else {
			for(int i = 0; i < size; i++) {
				if(element.equals(elements[i])) return i;
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	 
	/*	数组打印	*/
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("size = ").append(size).append(", [");
		for(int i = 0; i < size; i++) {
			if(i != 0)	string.append(",");
			string.append(elements[i]);
		}
		string.append("]");
		return string.toString();	
	}
}
