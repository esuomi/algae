package io.induct.algae.checksum;

import io.induct.algae.Checksum;

/**
 * Enumeration of various not-so-common checksum algorithms.
 *
 * @author EskoSuomi
 * @since 2014-10-18
 */
public enum Checksums implements Checksum {
    DAMM(new DammAlgorithm()),
    LUHN(new LuhnAlgorithm()),
    VERHOEFF(new VerhoeffAlgorithm());

    private final Checksum checksum;

    Checksums(Checksum checksum) {
        this.checksum = checksum;
    }

    @Override
    public boolean matches(String content, int checksum) {
        return this.checksum.matches(content, checksum);
    }

    @Override
    public int calculate(String input) {
        return this.checksum.calculate(input);
    }
}
