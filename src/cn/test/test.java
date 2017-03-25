package cn.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import cn.db.DB;

public class test {

	@Test
	public void test() {
		System.out.println(0.1+0.006);
		BigDecimal bd = new BigDecimal("asd");
		//System.out.println(bd.toString());
	}
	@Test
	public void testDB() {
		System.out.println(DB.getAllBook());
		System.out.println(DB.findBook("1"));
	}
	@Test
	public void testParse() {
		System.out.println(Integer.parseInt("12"));
	}
	@Test
	public void testArray() {
		int[] arr1 = {1,2,3};
		Integer [] arr2 = {1,2,3};
		List list1 = Arrays.asList(arr1);
		System.out.println(((int[])list1.get(0))[0]);
		List list2 = Arrays.asList(arr2);
		System.out.println(list2.get(0));
		Set set = new HashSet();
		System.out.println(set instanceof Collection);
		
		Class<?> cls = arr1.getClass();
		System.out.println(cls.toString());
		System.out.println(cls.isArray());
		
		System.out.println("<a href='http://www.baidu.com/'>百度一下</a>".length());
	}
}
