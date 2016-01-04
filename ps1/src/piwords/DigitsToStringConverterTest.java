package piwords;

import static org.junit.Assert.*;

import org.junit.Test;

public class DigitsToStringConverterTest {
    @Test
    public void basicNumberSerializerTest() {
        // Input is a 4 digit number, 0.123 represented in base 4
        int[] input = {0, 1, 2, 3};
        int[] invalid = {0, -1, 0};

        // Want to map 0 -> "d", 1 -> "c", 2 -> "b", 3 -> "a"
        char[] alphabet = {'d', 'c', 'b', 'a'};
        char[] shortAlph = {'d'};

        String expectedOutput = "dcba";
        assertEquals(expectedOutput,
                     DigitsToStringConverter.convertDigitsToString(
                             input, 4, alphabet));
        assertEquals(null, DigitsToStringConverter.convertDigitsToString(input, 2, alphabet));
        assertEquals(null, DigitsToStringConverter.convertDigitsToString(invalid, 2, alphabet));
        assertEquals(null, DigitsToStringConverter.convertDigitsToString(input, 4, shortAlph));
        
    }

    // TODO: Write more tests (Problem 3.a)
}
