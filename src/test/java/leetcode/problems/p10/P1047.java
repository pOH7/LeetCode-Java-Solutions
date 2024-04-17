package leetcode.problems.p10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 1047. Remove All Adjacent Duplicates In String
 *
 * @link https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 * @author zhanglei
 * @date 2022/3/2
 */
class P1047 {
    public String removeDuplicates(String s) {
        char[] n = new char[s.length()];
        int nLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (nLength == 0 || n[nLength - 1] != c) {
                n[nLength++] = c;
            } else {
                nLength--;
            }
        }
        return new String(n, 0, nLength);
    }

    @Test
    void test1() {
        assertEquals("ca", removeDuplicates("abbaca"));
    }

    @Test
    void test2() {
        assertEquals("ay", removeDuplicates("azxxzy"));
    }
}
