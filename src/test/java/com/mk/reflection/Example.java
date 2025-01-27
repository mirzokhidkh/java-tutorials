package com.mk.reflection;

public class Example {
    private String name;
    private int age;

    // Constructor
    public Example(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Example() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}