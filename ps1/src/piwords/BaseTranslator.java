package piwords;

public class BaseTranslator {
    /**
     * Converts an array where the ith digit corresponds to (1 / baseA)^(i + 1)
     * digits[i], return an array output of size precisionB where the ith digit
     * corresponds to (1 / baseB)^(i + 1) * output[i].
     * 
     * Stated in another way, digits is the fractional part of a number
     * expressed in baseA with the most significant digit first. The output is
     * the same number expressed in baseB with the most significant digit first.
     * 
     * To implement, logically, you're repeatedly multiplying the number by
     * baseB and chopping off the most significant digit at each iteration:
     * 
     * for (i < precisionB) {
     *   1. Keep a carry, initialize to 0.
     *   2. From RIGHT to LEFT
     *   	a. x = multiply the ith digit by baseB and add the carry
     *      b. the new ith digit is x % baseA
     *      c. carry = x / baseA
     *   3. output[i] = carry
     * 
     * If digits[i] < 0 or digits[i] >= baseA for any i, return null
     * If baseA < 2, baseB < 2, or precisionB < 1, return null
     * 
     * @param digits The input array to translate. This array is not mutated.
     * @param baseA The base that the input array is expressed in.
     * @param baseB The base to translate into.
     * @param precisionB The number of digits of precision the output should
     *                   have.
     * @return An array of size precisionB expressing digits in baseB.
     */
    public static int[] convertBase(int[] digits, int baseA,
                                    int baseB, int precisionB) {
        if (baseA < 2 || baseB < 2 || precisionB < 1)
            return null;
        int[] output = new int[precisionB];
        int[] digitsNew = digits.clone();
        for (int i = 0; i < precisionB; i++) {
            int carry = 0;
            for (int j = digitsNew.length-1; j >= 0; j--) {
                int d = digitsNew[j];
                if (d < 0 || d >= baseA) return null;
                int x = (d * baseB) + carry;
                digitsNew[j] = x % baseA;
                carry = x / baseA;
            }
            output[i] = carry;
        }
        return output;
    }
    
    
    public static void main(String[] args) {
        int[] input = {2,5};
        int[] arr = convertBase(input, 10, 3, 5);
        for (int i : arr)
            System.out.println(i);
    }
}
