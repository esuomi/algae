package io.induct.algae.substitution;

import io.induct.util.MoreStrings;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class AtbashSubstitutionCipherTest {

    @Test
    public void substitutesCharacterPairsCorrectly() throws Exception {
        String key = "abcdefghijklmnoprstuvwxyz";
        AtbashSubstitutionCipher atbash = new AtbashSubstitutionCipher(key.getBytes());
        byte[] substituted = atbash.substitute(key.getBytes());
        assertTrue(Arrays.equals(substituted, MoreStrings.reverse(key).getBytes()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void tryingToSubstituteUnknownCharacterWillThrowAnException() throws Exception {
        AtbashSubstitutionCipher atbash = new AtbashSubstitutionCipher("whatever".getBytes());
        atbash.substitute("0".getBytes());
    }
}