package leetcode.problems.p00;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 17. Letter Combinations of a Phone Number
 *
 * @link https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * @author zhanglei
 * @date 2022/4/11
 */
class P0017 {
    public List<String> letterCombinations(String digits) {
        char[][] phone =
                new char[][] {
                    {'a', 'b', 'c'},
                    {'d', 'e', 'f'},
                    {'g', 'h', 'i'},
                    {'j', 'k', 'l'},
                    {'m', 'n', 'o'},
                    {'p', 'q', 'r', 's'},
                    {'t', 'u', 'v'},
                    {'w', 'x', 'y', 'z'}
                };
        List<String> result = new ArrayList<>();
        letterCombinations(digits, 0, phone, new StringBuilder(), result);
        return result;
    }

    void letterCombinations(
            String digits, int cur, char[][] phone, StringBuilder temp, List<String> result) {
        if (cur == digits.length()) {
            if (cur > 0) {
                result.add(temp.toString());
            }
        } else {
            char c = digits.charAt(cur);
            for (char d : phone[c - '2']) {
                temp.append(d);
                letterCombinations(digits, cur + 1, phone, temp, result);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    @Test
    void test1() {
        assertEquals("[ad, ae, af, bd, be, bf, cd, ce, cf]", letterCombinations("23").toString());
    }

    @Test
    void test2() {
        assertEquals("[]", letterCombinations("").toString());
    }

    @Test
    void test3() {
        assertEquals("[a, b, c]", letterCombinations("2").toString());
    }
}
