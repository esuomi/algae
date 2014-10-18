package io.induct.algae.checksum;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author EskoSuomi
 * @since 2014-10-18
 */
public class VerhoeffAlgorithmTests {

    private VerhoeffAlgorithm verhoeff;

    @Before
    public void setUp() throws Exception {
        verhoeff = new VerhoeffAlgorithm();
    }

    @Test
    public void basicWikipediaCase() throws Exception {
        assertThat(verhoeff.matches("236", 3), is(true));
    }
}
