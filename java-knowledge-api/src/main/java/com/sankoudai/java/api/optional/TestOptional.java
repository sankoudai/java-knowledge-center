package com.sankoudai.java.api.optional;


import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TestOptional extends TestCase{
    public void testOptional() {
        Map<String, String> m = new HashMap<>();
        m.put("count", "d");
        String s = Optional.ofNullable(m).map(x->x.get("count")).filter(String::isEmpty).orElse("-1");
        System.out.println(s);

        String a = null;
        s = Optional.ofNullable(a).orElse("abc");
        assert "abc".equals(s);
    }
}
