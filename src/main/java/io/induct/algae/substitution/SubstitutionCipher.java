package io.induct.algae.substitution;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 24.1.2015
 */
public interface SubstitutionCipher {

    byte[] substitute(byte[] bytes);

}
