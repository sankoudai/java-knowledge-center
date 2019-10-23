package com.sankoudai.java.apix.guava;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class TestIterables{
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testGetLast() {
        List<String> strings = Lists.newArrayList("one", "two", "three");
        assertEquals("three", Iterables.getLast(strings));

        List<String> emptyList = Lists.newArrayList();
        assertEquals(Iterables.getLast(emptyList, null), null);

        thrown.expect(NoSuchElementException.class);
        Iterables.getLast(emptyList);
    }
}
