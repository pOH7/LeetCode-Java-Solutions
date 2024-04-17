package leetcode.problems.p05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 541. Reverse String II
 *
 * @link https://leetcode.com/problems/reverse-string-ii/
 * @author zhanglei
 * @date 2022/2/25
 */
class P0541 {
    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i += 2 * k) {
            for (int low = i, high = Math.min(i + k - 1, str.length - 1);
                    low <= high;
                    low++, high--) {
                char t = str[low];
                str[low] = str[high];
                str[high] = t;
            }
        }
        return new String(str);
    }

    @Test
    void test1() {
        assertEquals("bacdfeg", reverseStr("abcdefg", 2));
    }

    @Test
    void test2() {
        assertEquals("bacd", reverseStr("abcd", 2));
    }
}
