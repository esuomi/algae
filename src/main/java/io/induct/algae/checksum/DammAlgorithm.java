package io.induct.algae.checksum;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;

/**
 * Checksum validator using Damm algorithm.
 * @author EskoSuomi
 * @since 2014-10-18
 * @see <a href="http://en.wikipedia.org/wiki/Damm_algorithm">Damm algorithm</a>
 */
public final class DammAlgorithm implements Checksum {

    DammAlgorithm() {}

    private final int[][] QUASI_GROUP = {
            {0, 3, 1, 7, 5, 9, 8, 6, 4, 2},
            {7, 0, 9, 2, 1, 5, 4, 8, 6, 3},
            {4, 2, 0, 6, 8, 7, 1, 3, 5, 9},
            {1, 7, 5, 0, 9, 8, 3, 4, 2, 6},
            {6, 1, 2, 3, 0, 4, 5, 9, 7, 8},
            {3, 6, 7, 4, 2, 0, 9, 5, 8, 1},
            {5, 8, 6, 9, 7, 2, 0, 1, 3, 4},
            {8, 9, 4, 5, 3, 6, 2, 0, 1, 7},
            {9, 4, 3, 8, 6, 1, 7, 2, 0, 5},
            {2, 5, 8, 1, 4, 3, 6, 7, 9, 0}
    };

    @Override
    public boolean matches(String content, int checksum) {
        return calculate(content) == checksum;
    }

    @Override
    public int calculate(String input) {
        int checksum = 0;
        Preconditions.checkNotNull(input);
        String digitsStr = CharMatcher.DIGIT.retainFrom(input);
        for (int i = 0; i < digitsStr.length(); i++) {
            int n = Integer.parseInt(digitsStr.substring(i, i + 1));
            checksum = QUASI_GROUP[checksum][n];
        }
        return checksum;
    }
}
