package com.sankoudai.java.basics.topics.reflection;

import junit.framework.TestCase;

/**
 * @author : sankoudai
 * @version : created at 2016/2/14
 */
public class TestMethod extends TestCase {
    public void testGetMethods() {

    }

    private static class Person {
        private String name;
        private String gender;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
