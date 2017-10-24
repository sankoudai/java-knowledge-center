package com.sankoudai.java.apix.lombok;

import lombok.Data;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sankoudai on 24/10/2017.
 */
public class HelloLombok {
    @Data
    class Person {
        private String name;
    }

    @Test
    public void testData() {
        String name = "lombok";

        Person person = new Person();
        person.setName(name);
        Assert.assertEquals(person.getName(), name);
    }
}
