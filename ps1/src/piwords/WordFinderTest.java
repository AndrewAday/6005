package piwords;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class WordFinderTest {
    @Test
    public void basicGetSubstringsTest() {
        String haystack = "abcde";
        String empty = "";
        String[] needles = {"ab", "abc", "de", "fg"};
        String[] needles_new = {"ab", "abc", "de", "fg", "xyz"};
        String[] missing = {"xyz", "ppp"};
        String[] none = {};
        

        Map<String, Integer> expectedOutput = new HashMap<String, Integer>();
        expectedOutput.put("ab", 0);
        expectedOutput.put("abc", 0);
        expectedOutput.put("de", 3);
        
        Map<String, Integer> missingOutput = new HashMap<>();

        assertEquals(expectedOutput, WordFinder.getSubstrings(haystack,
                                                              needles));  // all needles found
        assertEquals(expectedOutput, WordFinder.getSubstrings(haystack,
                                                              needles_new));  // some needles found
        
        assertEquals(missingOutput, WordFinder.getSubstrings(haystack, missing));  // no shared substrings
        assertEquals(missingOutput, WordFinder.getSubstrings(empty, needles));  // no haystack 
        assertEquals(missingOutput, WordFinder.getSubstrings(haystack, none));  // no needles
    }

    // TODO: Write more tests (Problem 4.a)
}
