package io.induct.util;

import com.google.common.base.Preconditions;

/**
 * Things not available in {@link com.google.common.base.Strings}
 *
 * @since 24.1.2015
 */
public class MoreStrings {
    public static String reverse(String s) {
        Preconditions.checkNotNull(s, "null String is irreversible");
        if (s.length() > 0) {
            return new StringBuilder(s.length())
                    .append(s)
                    .reverse()
                    .toString();
        } else {
            return s;
        }
    }
}
