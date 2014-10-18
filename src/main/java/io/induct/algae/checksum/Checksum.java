package io.induct.algae.checksum;

/**
 * @author EskoSuomi
 * @since 2014-10-18
 */
public interface Checksum {
    boolean matches(String content, int checksum);

    int calculate(String input);
}
