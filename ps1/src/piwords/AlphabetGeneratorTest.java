package piwords;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlphabetGeneratorTest {
    @Test
    public void generateFrequencyAlphabetTest() {
        // Expect in the training data that Pr(a) = 2/5, Pr(b) = 2/5,
        // Pr(c) = 1/5.
        String[] trainingData = {"aa", "bbc"};
        String[] pollutedTrainingData = {"aa23", "132bbc"};
        // In the output for base 10, they should be in the same proportion.
        char[] expectedOutput = {'a', 'a', 'a', 'a',
                                 'b', 'b', 'b', 'b',
                                 'c', 'c'};
        assertArrayEquals(expectedOutput,
                AlphabetGenerator.generateFrequencyAlphabet(
                        10, trainingData));  // normal input
        assertArrayEquals(expectedOutput,
                AlphabetGenerator.generateFrequencyAlphabet(
                        10, pollutedTrainingData));  // training data contains nonalphabetical characters
        assertEquals(null, AlphabetGenerator.generateFrequencyAlphabet(-1, trainingData));  // base < 0
    }
}
