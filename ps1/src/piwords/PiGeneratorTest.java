package piwords;

import static org.junit.Assert.*;

import org.junit.Test;

public class PiGeneratorTest {
	
	@Test
    public void basicPowerModTest() {
        // 5^7 mod 23 = 17
        assertEquals(17, PiGenerator.powerMod(5, 7, 23));
        assertEquals(-1, PiGenerator.powerMod(-1, 1, 1));  // base < 0
        assertEquals(-1, PiGenerator.powerMod(1, -1, 1));  // exp < 0
        assertEquals(-1, PiGenerator.powerMod(1, 1, 0));  // mod < 1
        // 45^13 mod 257 = 56
        assertEquals(56, PiGenerator.powerMod(45, 13, 257));  // large numbers, shouldn't overflow 32-bit integer type
    }
    
    @Test
    public void computePiInHexTest() {
        assertEquals(null, PiGenerator.computePiInHex(-1));
        assertArrayEquals(new int[]{}, PiGenerator.computePiInHex(0));
        assertArrayEquals(new int[]{3,2,4,3,15}, PiGenerator.computePiInHex(5));
    }
}
