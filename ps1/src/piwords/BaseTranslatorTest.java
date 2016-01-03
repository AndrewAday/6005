package piwords;

import static org.junit.Assert.*;

import org.junit.Test;

public class BaseTranslatorTest {
    @Test
    public void basicBaseTranslatorTest() {
        // Expect that .01 in base-2 is .25 in base-10
        // (0 * 1/2^1 + 1 * 1/2^2 = .25)
        int[] input = {0, 1};
        int[] invalidInput = {-1, 0};
        int[] expectedOutput = {2, 5};
        assertArrayEquals(expectedOutput,
                          BaseTranslator.convertBase(input, 2, 10, 2));  // normal input
        assertArrayEquals(null,
                            BaseTranslator.convertBase(input, 2, 10, 0));  // precisionB < 1\
        assertArrayEquals(new int[]{2,5,0,0},
                BaseTranslator.convertBase(input, 2, 10, 4));  // precisionB > precisionA
        assertArrayEquals(new int[]{2},
                BaseTranslator.convertBase(input, 2, 10, 1));  // precisionB < precisionA
        assertEquals(null, BaseTranslator.convertBase(invalidInput, 2, 10, 1));  // digits contain negative number
        assertEquals(null, BaseTranslator.convertBase(input, 1, 10, 1));  // baseA < 2
        assertEquals(null, BaseTranslator.convertBase(input, 2, 1, 1));  // baseB < 2
        assertEquals(null, BaseTranslator.convertBase(input, 1, 10, 1));  // digits not in base
    }

    // TODO: Write more tests (Problem 2.a)
}
