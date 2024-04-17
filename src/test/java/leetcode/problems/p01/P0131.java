package leetcode.problems.p01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 *
 * @link https://leetcode.com/problems/palindrome-partitioning/
 * @author zhanglei
 * @date 2022/4/14
 */
class P0131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partition(s, 0, new ArrayList<>(), result);
        return result;
    }

    void partition(String s, int index, List<String> temp, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = index; i < s.length(); i++) {
                if (!isPalindrome(s, index, i)) {
                    continue;
                }
                String palindrome = s.substring(index, i + 1);
                temp.add(palindrome);
                partition(s, i + 1, temp, result);
                temp.remove(temp.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int start, int end) {
        return s.charAt(start) == s.charAt(end)
                && (start + 1 > end - 1 || isPalindrome(s, start + 1, end - 1));
    }

    @Test
    void test1() {
        assertEquals("[[a, a, b], [aa, b]]", partition("aab").toString());
    }

    @Test
    void test2() {
        assertEquals("[[a]]", partition("a").toString());
    }

    @Test
    void test3() {
        assertEquals("[[e, f, e], [efe]]", partition("efe").toString());
    }

    @Test
    void test4() {
        assertEquals(
                "[[c, b, b, b, c, c], [c, b, b, b, cc], [c, b, bb, c, c], [c, b, bb, cc], [c, bb, b, c, c], [c, bb, b, cc], [c, bbb, c, c], [c, bbb, cc], [cbbbc, c]]",
                partition("cbbbcc").toString());
    }
}
