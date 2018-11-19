package com.revature.reflection;

import java.lang.reflect.Field;

public class NameChanger {
	
    private static String clazzName = "reflection.Trainee";
    private static String fieldName = "name";
    
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName(clazzName);
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        Object obj = clazz.newInstance();
        System.out.println(field.get(obj));
        field.set(obj, "My name is Jeff");
        System.out.println(field.get(obj));
    }

}
