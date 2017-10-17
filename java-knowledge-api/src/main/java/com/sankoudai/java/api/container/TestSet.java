package com.sankoudai.java.api.container;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sankoudai on 16/10/2017.
 */
public class TestSet extends TestCase {
    @Test
    public void testSetOfBoxer() {
        Set<Long> set = new HashSet<>();
        set.add(1L);
        set.add(2L);
        set.add(null);
        assert (set.contains(1L));
    }
}
