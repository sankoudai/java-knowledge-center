package com.sankoudai.java.apix.guava;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import org.junit.Test;

/**
 * @author xuliufeng
 */
public class TestSets {
    @Test
    public void unionTest() {
        // union of null: throw Exception
        try{
            Sets.union(null, ImmutableSet.of(1, 2, 3));
            assert false;
        }catch (Exception e) {}
    }
}
