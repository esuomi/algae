package io.induct.algae.substitution;

import io.induct.util.MoreArrays;

import java.util.Arrays;

import static io.induct.util.MoreArrays.shift;

/**
 * Also known as shift cipher
 *
 * @since 24.1.2015
 * @see <a href="http://en.wikipedia.org/wiki/Caesar_cipher">Caesar cipher</a>
 */
public class CaesarSubstitutionCipher extends AbstractSubstitutionCipher implements SubstitutionCipher {

    private final byte[] lookup;

    public CaesarSubstitutionCipher(int offset, byte[] key) {
        this.lookup = new byte[Byte.MAX_VALUE];
        Arrays.fill(lookup, (byte) -1);
        byte[] shifted = shift(offset, key);
        for (int i = 0; i < key.length; i++) {
            this.lookup[key[i]] = shifted[i];
        }
    }

    @Override
    protected byte lookup(byte b) {
        byte v = lookup[b];
        if (v >= 0) {
            return v;
        }
        return b;
    }
}
