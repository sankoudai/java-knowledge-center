package com.sankoudai.java.apix.apache.collection;

import junit.framework.TestCase;
import org.apache.commons.collections.map.MultiKeyMap;

/**
 * @author xuliufeng
 */
public class TestMultiKeyMap extends TestCase {
    public void testGetPut() {
        MultiKeyMap m = new MultiKeyMap();
        m.put("a1", "b1", 3);

        assert m.get("a1", "b2") == null;

        Integer i = (Integer) m.get("a1", "b1");
        assert(i==3);
        assert m.get("a1", "b2") == null;
    }
}
