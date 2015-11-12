package com.sankoudai.java.apix.jackson;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sankoudai.java.apix.jackson.entity.ExampleEntity;
import junit.framework.TestCase;

import java.io.IOException;

/**
 * @author : sankoudai
 * @version : created at 2015/10/5
 */
public class HelloJackson extends TestCase{
    public static void main(String args[]) {

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";

        //map json to student

        try {
            ExampleEntity student = mapper.readValue(jsonString, ExampleEntity.class);

            System.out.println(student);

            jsonString = mapper.writeValueAsString(student);

            System.out.println(jsonString);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


