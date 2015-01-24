package io.induct.algae.substitution;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CaesarSubstitutionCipherTest {

    @Test
    public void substitutesValuesAccordingToGivenKey() throws Exception {
        String key = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        CaesarSubstitutionCipher caesar = new CaesarSubstitutionCipher(3, key.getBytes());
        assertEquals("QEB NRFZH YOLTK CLU GRJMP LSBO QEB IXWV ALD", new String(caesar.substitute("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG".getBytes())));
    }
}