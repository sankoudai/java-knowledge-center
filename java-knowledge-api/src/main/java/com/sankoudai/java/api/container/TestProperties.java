package com.sankoudai.java.api.container;

import junit.framework.TestCase;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Properties是一个散列表， 父类是Hashtable;
 * key 和 value 都是String类型的
 * 提供了API方法： 可以利用文件初始化散列表数据
 * 用途： 使得软件的参数可以后期配置修改
 *
 * @author : sankoudai
 * @version : created at 2015/8/11
 */
public class TestProperties extends TestCase {
    public void testLoad() throws Exception {
        Properties properties = new Properties();

        InputStream in = getClass().getResourceAsStream("/test.properties");
        properties.load(in);
        System.out.printf("properties = %s \n", properties);
    }

    public void testSetProperties() {
        Properties properties = new Properties();
        properties.setProperty("name", "jim");
    }

    public void testGetProperties() {
        Properties properties = getTestProperties();
        String key = "name";
        String val = properties.getProperty(key);
        System.out.printf("testGetProperties: key = %s, val = %s", key, val);
    }

    private Properties getTestProperties() {
        Properties properties = new Properties();

        InputStream in = getClass().getResourceAsStream("/test.properties");
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }
}
