package io.induct.util;

import org.junit.Test;

import static io.induct.util.MoreStrings.reverse;
import static org.junit.Assert.*;

public class MoreStringsTest {

    @Test
    public void reverseWorks() throws Exception {
        // generally tests like this are a bit redundant...
        assertEquals("cba", reverse("abc"));
    }
}