package com.JL;

public class Person {
	private int age;
	private String nameString;
	
	public Person(int age, String nameString) {
		this.age = age;
		this.nameString = nameString;
	}
	
	@Override
	public String toString() {
		return "Person [age=" + age + ", nameString=" + nameString + "]";
	}
	
	//默认equals为比较地址，也就是“==”的作用
	@Override
	public boolean equals(Object object) {
		if(object == null) return false;
		if(object instanceof Person) {
			Person person = (Person) object;
			return this.age == person.age;
		}
		return false;
	}
}
