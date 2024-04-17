package leetcode.problems.p22;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 *
 * @link https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * @author zhanglei
 * @date 2022/2/25
 */
class P2297 {
    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        reverseWords(chars, 0, chars.length - 1);
        reverseWords(chars, 0, chars.length - n - 1);
        reverseWords(chars, chars.length - n, chars.length - 1);
        return new String(chars);
    }

    static void reverseWords(char[] chars, int low, int high) {
        for (int i = low, j = high; i <= j; i++, j--) {
            char t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;
        }
    }

    @Test
    void test1() {
        assertEquals("cdefgab", reverseLeftWords("abcdefg", 2));
    }

    @Test
    void test2() {
        assertEquals("umghlrlose", reverseLeftWords("lrloseumgh", 6));
    }
}
