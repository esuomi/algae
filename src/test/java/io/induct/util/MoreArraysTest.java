package io.induct.util;

import org.junit.Test;

import java.util.Arrays;

import static io.induct.util.MoreArrays.shift;
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

    @Test
    public void shiftsByteArrayCorrectly() throws Exception {
        assertShift(2, "abcde", "deabc");
        assertShift(-2, "abcde", "cdeab");
    }

    private void assertShift(int offset, String input, String expected) {
        assertEquals(expected, new String(shift(offset, input.getBytes())));
    }
}