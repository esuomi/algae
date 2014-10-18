package io.induct.algae.checksum;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author EskoSuomi
 * @since 2014-10-18
 */
public class VerhoeffAlgorithmTests {

    private VerhoeffAlgorithm verhoeff = VerhoeffAlgorithm.INSTANCE;

    @Test
    public void basicWikipediaCase() throws Exception {
        assertThat(verhoeff.matches("236", 3), is(true));
    }
}
