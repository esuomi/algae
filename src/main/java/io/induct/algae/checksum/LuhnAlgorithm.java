package io.induct.algae.checksum;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;

/**
 * Checksum validator using Luhn algorithm.
 *
 * @author EskoSuomi
 * @since 2014-10-18
 * @see <a href="http://en.wikipedia.org/wiki/Luhn_algorithm">Luhn algorithm</a>
 */
public class LuhnAlgorithm implements Checksum {

    // TODO: Some enum thingy for describind security? Like LuhnAlgorithm.Validity.isCryptographicallySecure()

    @Override
    public boolean matches(String content, int checksum) {
        return calculate(content) == checksum;
    }

    @Override
    public int calculate(String input) {
        Preconditions.checkNotNull(input);
        String digitsStr = CharMatcher.DIGIT.retainFrom(input);
        int sum = 0;
        for (int i = 0; i < digitsStr.length(); i++) {
            int n = Integer.parseInt(digitsStr.substring(i, i + 1));
            if (i % 2 != 0 && i % 1 == 0) {
                n <<= 1;
                if (n >= 10) {
                    n = (n % 10) + (n / 10);
                }
            }
            sum += n;
        }
        return (sum * 9) % 10;
    }
}
