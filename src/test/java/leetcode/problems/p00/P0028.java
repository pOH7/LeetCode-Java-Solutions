package leetcode.problems.p00;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 28. Implement strStr()
 *
 * @link https://leetcode.com/problems/implement-strstr/
 * @author zhanglei
 * @date 2022/2/25
 */
class P0028 {

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int[] next = buildNext(needle);
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else if (j > 0) {
                j = next[j - 1];
            } else {
                i++;
            }
            if (j == needle.length()) {
                return i - needle.length();
            }
        }
        return -1;
    }

    // \sigma(x) = max{k: P_k \sqsupset x}
    static int[] buildNext(String str) {
        int[] next = new int[str.length()];
        int i = 1;
        int j = 0;
        while (i < str.length()) {
            if (str.charAt(i) == str.charAt(j)) {
                next[i] = j + 1;
                i++;
                j++;
            } else if (j > 0) {
                j = next[j - 1];
            } else {
                i++;
            }
        }
        return next;
    }

    @Test
    @Disabled
    void testBuildNext() {
        assertEquals("[0, 0, 0, 1, 2, 0]", Arrays.toString(buildNext("abcabd")));
    }

    /*
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
    */

    /*
    // native string matcher
    // O((n-m)m)
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(j + i) != needle.charAt(j)) {
                    break;
                }
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
    */

    @Test
    void test1() {
        assertEquals(2, strStr("hello", "ll"));
    }

    @Test
    void test2() {
        assertEquals(-1, strStr("aaaaa", "bba"));
    }

    @Test
    void test3() {
        assertEquals(0, strStr("", ""));
    }
}
