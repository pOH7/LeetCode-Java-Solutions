package leetcode.problems.p01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 151. Reverse Words in a String
 *
 * @link https://leetcode.com/problems/reverse-words-in-a-string/
 * @author zhanglei
 * @date 2022/2/25
 */
class P0151 {

    /*
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        for (int i = 0, j = words.length - 1; i <= j; i++, j--) {
            String t = words[i];
            words[i] = words[j];
            words[j] = t;
        }
        return String.join(" ", words);
    }
    */

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();

        // step 1. clean up spaces
        int l = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' '
                    && (l == 0 // first ?
                            || i == chars.length - 1 // last ?
                            || chars[i + 1] == ' ' // middle ?
                    )) {
                continue;
            }
            chars[l++] = chars[i];
        }

        // step 2. reverse the whole string
        reverse(chars, 0, l - 1);

        // step 3. reverse each word
        for (int s1 = 0; s1 < l; s1++) {
            if (chars[s1] == ' ') {
                continue;
            }
            for (int s2 = s1; s2 < l; s2++) {
                if (s2 + 1 < l && chars[s2 + 1] != ' ') {
                    continue;
                }
                reverse(chars, s1, s2);
                s1 = s2 + 1;
                break;
            }
        }

        return new String(chars, 0, l);
    }

    static void reverse(char[] chars, int low, int high) {
        for (int i = low, j = high; i <= j; i++, j--) {
            char t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;
        }
    }

    @Test
    void test1() {
        assertEquals("blue is sky the", reverseWords("the sky is blue"));
    }

    @Test
    void test2() {
        assertEquals("world hello", reverseWords("  hello world  "));
    }

    @Test
    void test3() {
        assertEquals("example good a", reverseWords("a good   example"));
    }
}
