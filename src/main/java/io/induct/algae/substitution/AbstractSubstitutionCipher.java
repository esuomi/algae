package io.induct.algae.substitution;

import com.google.common.base.Preconditions;

/**
 * @since 24.1.2015
 */
abstract class AbstractSubstitutionCipher implements SubstitutionCipher {

    @Override
    public byte[] substitute(byte[] bytes) {
        Preconditions.checkNotNull(bytes, "Cannot substitute contents of null array");

        byte[] substituted = new byte[bytes.length];
        for (int i = 0; i < substituted.length; i++) {
            substituted[i] = lookup(bytes[i]);
        }
        return substituted;
    }

    protected abstract byte lookup(byte b);
}
