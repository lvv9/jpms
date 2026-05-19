package me.liuweiqiang.entity;

import me.liuweiqiang.entity.ignored.Loaded;
import me.liuweiqiang.entity.ignored.NotLoaded;
import me.liuweiqiang.entity2.Consumable;
import me.liuweiqiang.no.circle.John;
import me.liuweiqiang.unnamed.PublicClass;

import java.lang.reflect.Constructor;

public class Hello {

    @Override
    public String toString() {
        return "Hello";
    }

    public static void main(String[] args) throws Exception {
        // if a package is defined in both a named module and the unnamed module then the package in the unnamed module is ignored.
        // when run by IDE:
        // - entity in class path, i.e., thus entity is an unnamed module
        // - entity_new in class path
        // make entity in class path, entity_new in module path to observe the exceptions
        // will not boot if split package me.liuweiqiang.entity.ignored into named modules(artifact.entity & entity_new)
        try {
            new NotLoaded();
        } catch (NoClassDefFoundError e) {
            e.printStackTrace();
        }
        // try running jar with [--add-modules entity_new] to make module entity_new observable
        new Loaded();
        // can be accessed even it is opened only
        Consumable consumable = new Consumable();
        consumable.get("test01");
        // but can not be accessed when it is not declared
        Class<?> clazz = Class.forName("me.liuweiqiang.entity2.internal.InternalConsumable");
        // the class can not be accessed even package me.liuweiqiang.entity is in unnamed module
        // unless we launch application in a legacy way ([-cp], run main() by IDE directly)
        try {
            clazz.getDeclaredConstructor().newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println(new PublicClass());
        Class<?> unnamedPrivateClazz = Class.forName("me.liuweiqiang.unnamed.PrivateClass");
        Constructor<?> constructor = unnamedPrivateClazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        System.out.println(constructor.newInstance());

        System.out.println(new John());
    }
}
