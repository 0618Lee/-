package com.JL;

//提醒垃圾回收：		System.gc();   ,JVM垃圾回收机制运行时不定时的，使用前面指令可以手动使之进行

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(2);
		ArrayList<Person> persons = new ArrayList<>(2);
		persons.add(new Person(10, "John"));
		persons.add(new Person(20, "James"));
		persons.add(new Person(30, "Rose"));
		list.add(99);
		list.add(88);
		list.add(77);
		list.remove(1);
		list.add(list.size(),66);
		System.out.println(persons.indexOf(new Person(10,"John")));
		System.out.println(list);
		System.out.println(persons);
	}
}
