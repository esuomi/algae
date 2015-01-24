package io.induct.algae.substitution;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Iterables;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class Rot13SubstitutionCipherTest {

    @Test
    @Ignore
    public void testPerf() throws Exception {
        List<Long> runTimes = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            Stopwatch loopTime = Stopwatch.createStarted();
            for (int j = 0; j < 1000000; j++) {
                substitutesExampleFromWikipediaCorrectly();
            }
            loopTime.stop();
            runTimes.add(loopTime.elapsed(TimeUnit.MILLISECONDS));
        }

        Collections.sort(runTimes);
        System.out.println("Fastest: " + runTimes.get(0) + "ms");
        System.out.println("Slowest: " + runTimes.get(9) + "ms");

        long sum = runTimes.stream().reduce((acc, x) -> acc + x).get();
        System.out.println("Average: " + (((double) sum + 0.5) / 10)  + "ms");
    }

    @Test
    public void substitutesExampleFromWikipediaCorrectly() throws Exception {
        LookupRot13SubstitutionCipher rot13 = LookupRot13SubstitutionCipher.INSTANCE;
        assertSubstitution(rot13, "Why did the chicken cross the road?", "Jul qvq gur puvpxra pebff gur ebnq?");
        assertSubstitution(rot13, "To get to the other side!", "Gb trg gb gur bgure fvqr!");
    }

    private static void assertSubstitution(SubstitutionCipher cipher, String expected, String actual) {
        String substituted = new String(cipher.substitute(actual.getBytes()));
        assertEquals(expected, substituted);
    }
}