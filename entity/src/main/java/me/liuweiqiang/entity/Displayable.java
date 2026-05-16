package me.liuweiqiang.entity;

import me.liuweiqiang.entity.ignored.Loaded;
import me.liuweiqiang.entity.ignored.NotLoaded;
import me.liuweiqiang.entity2.Consumable;

import java.lang.reflect.InvocationTargetException;

public class Displayable {

    @Override
    public String toString() {
        return "Hello";
    }

    public static void main(String[] args) {
        // If a package is defined in both a named module and the unnamed module then the package in the unnamed module is ignored.
        try {
            new NotLoaded();
        } catch (NoClassDefFoundError e) {
            e.printStackTrace();
        }
        new Loaded();
        // [--add-modules entity_new] to make module entity_new observable
        Consumable consumable = new Consumable();
        consumable.get("test01");
        Class<?> clazz;
        try {
            clazz = Class.forName("me.liuweiqiang.entity2.internal.InternalConsumable");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        // the class can not be accessed even package me.liuweiqiang.entity is in unnamed module
        // unless we launch application in a legacy way ([-cp], try running main directly)
        try {
            clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
