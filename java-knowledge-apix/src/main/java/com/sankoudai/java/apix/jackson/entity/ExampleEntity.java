package com.sankoudai.java.apix.jackson.entity;

/**
 * @author : sankoudai
 * @version : created at 2015/10/5
 */
public class ExampleEntity {
    private String name;
    private int age;

    public ExampleEntity() {
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

    public String toString() {
        return "ExampleEntity [ name: " + name + ", age: " + age + " ]";
    }
}
