package com.sankoudai.java.apix.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import junit.framework.TestCase;
import org.junit.Assert;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by sankoudai on 18/04/2018.
 */
public class TestGson extends TestCase {
    public static class GClass {
        public String name;
        public int age;
    }

    public static class GFClass<T> {
        public T getObj(String json) {
            Gson gsonParser = new Gson();

            final Type typeOf = new TypeToken<T>() {
            }.getType();

            System.out.println(typeOf);
            return gsonParser.fromJson(json, typeOf);
        }
    }

    public void testParameterizedTypeToken() {
        String json = "{\"name\":\"jim\", \"age\":10}";
        GFClass<GClass> gfClass = new GFClass<GClass>();
        try {
            GClass gClass = gfClass.getObj(json);
            Assert.fail();
        }catch (Exception ignored) {
        }
    }

    public void testFromJson() {
        Gson gsonParser = new Gson();
        String mapList = "[{\"1\": 123, \"2\":1},{\"1\": 456, \"2\":0}]";
        List<Map<String, Long>> a = new ArrayList<>();

        final Type typeOf = new TypeToken<List<Map<String, Long>>>() {
        }.getType();
        List<Map<String, Long>> obj = (List<Map<String, Long>>) gsonParser.fromJson(mapList, typeOf);
        Assert.assertTrue(obj.get(0).get("1") == 123L);
    }

}
