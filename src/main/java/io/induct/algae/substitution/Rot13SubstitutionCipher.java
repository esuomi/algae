package io.induct.algae.substitution;

/**
 * ROT13 substitution rules:
 *  - Alphabetics are shifted onwards 13 characters
 *  - Upper/lowercasing is kept accordingly
 *  - Punctuation and such is kept as is
 *
 * As this is ROT13 it only works with the Latin 26 character alphabet.
 *
 * Why? Because the world needs this.
 *
 * @since 24.1.2015
 * @see <a href="http://en.wikipedia.org/wiki/ROT13">ROT13</a>
 */
public final class Rot13SubstitutionCipher extends AbstractSubstitutionCipher implements SubstitutionCipher {

    public static final Rot13SubstitutionCipher INSTANCE = new Rot13SubstitutionCipher();

    private Rot13SubstitutionCipher() {}

    @Override
    protected byte lookup(byte b) {

        if (b > 96 && b < 123) {
            // lowercase substitution
            return (byte) ((b < 109) ? b + 13 : b - 13);
        } else if (b > 64 && b < 91) {
            // uppercase substitution
            return (byte) ((b < 78) ? b + 13 : b - 13);
        } else {
            return b;
        }
    }
}
