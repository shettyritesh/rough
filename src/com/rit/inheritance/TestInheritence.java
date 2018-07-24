package com.rit.inheritance;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class TestInheritence {

	@Test
	public void testGetLName() {
		try {
		Class targetClass=Inheritence.class;
		Method method = targetClass.getDeclaredMethod("getLastName");
		method.setAccessible(true);
		Inheritence i = new Inheritence("Ritesh", "Shetty");

			System.out.println(method.invoke(i, null));
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
