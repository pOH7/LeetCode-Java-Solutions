package leetcode.template;

import java.util.Arrays;

/**
 * @author zhanglei
 * @version 2024/11/21
 */
public class LPSTemplate {

    // Function to compute the LPS table
    public static int[] computeLPS(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n]; // LPS table

        int i = 1;
        int length = 0; // Length of the previous longest prefix suffix

        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                // Characters match; update length and LPS[i]
                length++;
                lps[i] = length;
                i++;
            } else if (length != 0) {
                // Try the previous longest prefix suffix
                length = lps[length - 1];
            } else {
                // No prefix suffix found; move to the next character
                i++;
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        String pattern = "ababcababa"; // Example pattern
        int[] lps = computeLPS(pattern);

        System.out.println("Pattern: " + pattern);
        System.out.println("LPS Table: " + Arrays.toString(lps));

        String pattern1 = "aaaaaaaaaa"; // Example pattern
        int[] lps1 = computeLPS(pattern1);

        System.out.println("Pattern: " + pattern1);
        System.out.println("LPS Table: " + Arrays.toString(lps1));
    }
}
