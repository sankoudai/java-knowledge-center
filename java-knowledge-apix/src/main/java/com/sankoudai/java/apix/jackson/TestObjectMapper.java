package com.sankoudai.java.apix.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sankoudai.java.apix.jackson.entity.ExampleEntity;
import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author : sankoudai
 * @version : created at 2015/10/5
 */
public class TestObjectMapper extends TestCase {
    /**
     * 测试: readValue将jsonString转化成 POJO
     *
     * @throws IOException
     */
    public void testReadValue() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        /* json --> POJO */
        String jsonString = "{\"name\":\"yun\", \"age\":21}";
        ExampleEntity entity = mapper.readValue(jsonString, ExampleEntity.class);
        System.out.printf("TestObjectMapper[testReadValue]--POJO:\n jsonString=%s,\n entity=%s\n", jsonString, entity);
        System.out.println();

        /* json --> List */
        String listString = "[1, 2, 3]";
        List list = mapper.readValue(listString, new TypeReference<List<Long>>() {});
        System.out.printf("TestObjectMapper[testReadValue]--List:\n listString=%s,\n list=%s, \nitemType=%s\n", jsonString, list, list.get(0).getClass());
        System.out.println();

        /*---------------from file-----------------*/
        entity = mapper.readValue(new File("src/main/resources/jackson/example.json"), ExampleEntity.class);
        System.out.printf("TestObjectMapper[testReadValue]--from file: entity=%s\n", jsonString, list, list.get(0).getClass());
    }

    /**
     * 测试: writeValueAsString将POJO转化成jsonString
     *
     * @throws JsonProcessingException
     */
    public void testWriteValueAsString() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        ExampleEntity entity = new ExampleEntity();
        entity.setName("yun");
        entity.setAge(21);

        /* to String */
        String jsonString = mapper.writeValueAsString(entity);
        System.out.printf("TestObjectMapper[testWriteValueAsString]:\n entity=%s,\n jsonString=%s\n ", entity, jsonString);

        /* to JSON file */
        mapper.writeValue(new File("src/main/resources/jackson/example.json"), entity);
    }
}
