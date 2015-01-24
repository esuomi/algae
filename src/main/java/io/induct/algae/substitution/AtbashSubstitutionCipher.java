package io.induct.algae.substitution;

import com.google.common.base.Preconditions;

import java.util.Arrays;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 24.1.2015
 * @see <a href="http://en.wikipedia.org/wiki/Atbash">Atbash cipher</a>
 */
public class AtbashSubstitutionCipher {

    private final static byte UNKNOWN_BYTE = -1;

    private final byte[] substitutions;

    public AtbashSubstitutionCipher(byte[] key) {
        substitutions = new byte[Byte.MAX_VALUE];
        Arrays.fill(substitutions, UNKNOWN_BYTE);
        for (int head = 0; head < key.length; head++) {
            byte headValue = key[head];
            Preconditions.checkArgument(headValue >= 0, "Cannot use negative byte value '" + headValue + "' for substitution");
            int tail = key.length - 1 - head;
            byte tailValue = key[tail];
            Preconditions.checkArgument(tailValue >= 0, "Cannot use negative byte value '" + tailValue + "' for substitution");
            substitutions[headValue] = tailValue;
        }
    }

    public byte[] substitute(byte[] bytes) {
        Preconditions.checkNotNull(bytes, "Cannot substitute contents of null array");

        byte[] substituted = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            byte sb = substitutions[b];
            Preconditions.checkArgument(sb >= 0, "No known substitution for byte " + b);
            substituted[i] = sb;
        }

        return substituted;
    }
}
