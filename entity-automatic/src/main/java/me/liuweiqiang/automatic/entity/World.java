package me.liuweiqiang.automatic.entity;

import me.liuweiqiang.entity.Hello;
import me.liuweiqiang.no.circle.John;

import java.lang.reflect.Method;

public class World {

    public String join() throws Exception {
        System.out.println(new John());

        Hello hello = new Hello();
        System.out.println(hello);
        Class<?> helloClazz = Class.forName("me.liuweiqiang.entity.Hello");
        Object helloInstance = helloClazz.getDeclaredConstructor().newInstance();
        Method toString = helloClazz.getDeclaredMethod("toString");
        String h = (String) toString.invoke(helloInstance);
        return h + "World";
    }

}
