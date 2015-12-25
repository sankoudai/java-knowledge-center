package com.sankoudai.java.api.container.stream;

import com.sankoudai.java.api.container.stream.bean.ExampleObj;
import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by xuliufeng on 2015/12/25.
 */
public class TestCollect extends TestCase{
    public void testToMap() {
        List<ExampleObj> objs = Arrays.asList(exampleObj());
        Map<Integer, ExampleObj> map = objs.stream().collect(Collectors.toMap(ExampleObj::getId, (p) -> p));
        System.out.println(map);
    }


    private ExampleObj exampleObj() {
        ExampleObj obj = new ExampleObj();
        obj.setId(1);
        obj.setName("name");
        return obj;
    }
}
