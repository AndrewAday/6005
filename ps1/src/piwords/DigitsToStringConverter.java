package piwords;
import java.util.HashMap;

public class DigitsToStringConverter {
    /**
     * Given a list of digits, a base, and an mapping of digits of that base to
     * chars, convert the list of digits into a character string by applying the
     * mapping to each digit in the input.
     * 
     * If digits[i] >= base or digits[i] < 0 for any i, consider the input
     * invalid, and return null.
     * If alphabet.length != base, consider the input invalid, and return null.
     *
     * @param digits A list of digits to encode. This object is not mutated.
     * @param base The base the digits are encoded in.
     * @param alphabet The mapping of digits to chars. This object is not
     *                 mutated.
     * @return A String encoding the input digits with alphabet.
     */
    public static String convertDigitsToString(int[] digits, int base,
                                               char[] alphabet) {
        if (base != alphabet.length) return null;
        HashMap<Integer,Character> lettering = new HashMap<>();
        for (int i = 0; i < alphabet.length; i++) {
            lettering.put(i, alphabet[i]);
        }
        String s = "";
        for (int d : digits) {
            if (d < 0 || d >= base) return null;
            s += lettering.get(d);
        }
        return s;
    }
}
