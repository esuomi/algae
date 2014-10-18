package io.induct.algae.checksum;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author EskoSuomi
 * @since 2014-10-18
 */
public class LuhnAlgorithmTests {

    private LuhnAlgorithm luhn = LuhnAlgorithm.INSTANCE;

    @Test
    public void basicWikipediaCase() throws Exception {
        assertThat(luhn.matches("7992739871", 3), is(true));
    }

    @Test
    public void basicInvalidWikipediaCases() throws Exception {
        for (int i : Arrays.asList(0,1,2,4,5,6,7,8,9)) {
            assertThat(luhn.matches("7992739871", i), is(false));
        }
    }
}
