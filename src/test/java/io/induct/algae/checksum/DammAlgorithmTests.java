package io.induct.algae.checksum;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author EskoSuomi
 * @since 2014-10-18
 */
public class DammAlgorithmTests {

    private DammAlgorithm damm = DammAlgorithm.INSTANCE;

    @Test
    public void basicWikipediaCase() throws Exception {
        assertThat(damm.matches("572", 4), is(true));
    }
}
