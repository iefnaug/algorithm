package com.datastructure.queue;

/**
 * @author GF
 * @since 2023/5/29
 */
public class Person implements Priority{

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int priority() {
        return age;
    }
}
