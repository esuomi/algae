package io.induct.algae.substitution;

import io.induct.util.MoreArrays;

/**
 * Alternate lookup table based implementation for ROT13 but slightly slower than {@link io.induct.algae.substitution.Rot13SubstitutionCipher}
 *
 * @since 24.1.2015
 */
public final class LookupRot13SubstitutionCipher extends AbstractSubstitutionCipher implements SubstitutionCipher {

    public static final LookupRot13SubstitutionCipher INSTANCE = new LookupRot13SubstitutionCipher();

    private LookupRot13SubstitutionCipher() {}

    private final static byte[][] LOOKUP = MoreArrays.pivot(new byte[][]{
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".getBytes(),
            "NOPQRSTUVWXYZABCDEFGHIJKLMnopqrstuvwxyzabcdefghijklm".getBytes()
    });

    @Override
    protected byte lookup(byte b) {
        if ((b > 96 && b < 123)) {
            // lowercase substitution
            return LOOKUP[b - 71][1];
        } else if ((b > 64 && b < 91)) {
            // uppercase substitution
            return LOOKUP[b - 65][1];
        } else {
            return b;
        }
    }
}
