package io.induct.algae.checksum;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;

/**
 * @author EskoSuomi
 * @since 2014-10-18
 */
public final class VerhoeffAlgorithm implements Checksum {

    public VerhoeffAlgorithm() {}

    public static final int[][] MULTIPLICATION = {
        { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
        { 1, 2, 3, 4, 0, 6, 7, 8, 9, 5 },
        { 2, 3, 4, 0, 1, 7, 8, 9, 5, 6 },
        { 3, 4, 0, 1, 2, 8, 9, 5, 6, 7 },
        { 4, 0, 1, 2, 3, 9, 5, 6, 7, 8 },
        { 5, 9, 8, 7, 6, 0, 4, 3, 2, 1 },
        { 6, 5, 9, 8, 7, 1, 0, 4, 3, 2 },
        { 7, 6, 5, 9, 8, 2, 1, 0, 4, 3 },
        { 8, 7, 6, 5, 9, 3, 2, 1, 0, 4 },
        { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 }
    };

    public static final int[] INVERSE = { 0, 4, 3, 2, 1, 5, 6, 7, 8, 9 };

    public static final int[][] PERMUTATION = {
        { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
        { 1, 5, 7, 6, 2, 8, 3, 0, 9, 4 },
        { 5, 8, 0, 3, 7, 9, 6, 1, 4, 2 },
        { 8, 9, 1, 6, 0, 4, 3, 5, 2, 7 },
        { 9, 4, 5, 3, 1, 2, 6, 8, 7, 0 },
        { 4, 2, 8, 6, 5, 7, 3, 9, 0, 1 },
        { 2, 7, 9, 3, 8, 0, 6, 4, 1, 5 },
        { 7, 0, 4, 6, 9, 1, 3, 2, 5, 8 }
    };

    @Override
    public boolean matches(String content, int checksum) {
        return calculate(content) == checksum;
    }

    @Override
    public int calculate(String input) {
        Preconditions.checkNotNull(input);
        String digitsStr = CharMatcher.DIGIT.retainFrom(input) + "0";
        int checksum = 0;
        int length = digitsStr.length() - 1;
        for (int i = length; i >= 0; i--) {
            int idx = length - i;
            int n = Integer.parseInt(digitsStr.substring(i, i + 1));
            checksum = MULTIPLICATION[checksum][PERMUTATION[idx % 8][n]];
            System.out.println(idx + " => " + n + " => " + checksum);
        }
        return INVERSE[checksum];
    }
}
