package cn.domain;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;



public class TestReflect {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Class<?> cls = Class.forName("cn.domain.Person");
		
		//得到构造方法private Person(String name)并生成对象实例
		Constructor<?> con = cls.getDeclaredConstructor(String.class);
		con.setAccessible(true);
		Object obj = con.newInstance("wangwu");
		System.out.println(obj);
		
		//得到年纪private int age;
		Field age = cls.getDeclaredField("age");
		age.setAccessible(true);		
		age.set(obj, 20);
		System.out.println(age.get(obj));
		
		//得到名字private String name
		Field name = cls.getDeclaredField("name");
		name.setAccessible(true);
		System.out.println(name.get(obj));
		name.set(obj, "huangjun");
		System.out.println(age.get(obj));
		
		System.out.println(obj);
		
		//得到方法public String getNameAge()
		Method getNameAge = cls.getMethod("getNameAge");
		System.out.println(getNameAge.invoke(obj));
		
		//得到方法private String getNamePlus(String plus)
		Method getNamePlus = cls.getDeclaredMethod("getNamePlus", String.class);
		getNamePlus.setAccessible(true);
		System.out.println(getNamePlus.invoke(obj, "_gogogo"));
	}
}

class Person {
	public String pub;
	private String name;
	private int age;
	public Person() {}
	private Person(String name) {
		this.name = name;
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	public String getNameAge() {
		return name+age;
	}
	private String getNamePlus(String plus) {
		return  name+plus;
	}
}