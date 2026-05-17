package me.liuweiqiang.automatic.entity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class World {

    public String join() {
        Class<?> helloClazz;
        try {
            helloClazz = Class.forName("me.liuweiqiang.entity.Hello");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Object helloInstance;
        try {
            helloInstance = helloClazz.getDeclaredConstructor().newInstance();
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        Method toString;
        try {
            toString = helloClazz.getDeclaredMethod("toString");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        String hello;
        try {
            hello = (String) toString.invoke(helloInstance);
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return hello + "World";
    }

    public static void main(String[] args) {
        System.out.println(new World().join());
    }

}
