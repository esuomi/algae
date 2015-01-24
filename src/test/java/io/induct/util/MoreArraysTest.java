package io.induct.util;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MoreArraysTest {

    @Test
    public void pivotsGivenTwoDimensionalArray() throws Exception {
        assertTrue(
                Arrays.deepEquals(MoreArrays.pivot(new byte[][] {
                        new byte[] { 'a', 'b', 'c' },
                        new byte[] { 'd', 'e', 'f' },
                }),
                new byte[][] {
                        new byte[] { 'a', 'd' },
                        new byte[] { 'b', 'e' },
                        new byte[] { 'c', 'f' }
                })
        );
    }
}