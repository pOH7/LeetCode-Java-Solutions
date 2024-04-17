package leetcode.problems.p03;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * 383. Ransom Note
 *
 * @link https://leetcode.com/problems/ransom-note/
 * @author zhanglei
 * @date 2022/2/24
 */
public class P0383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] hash = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            hash[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (hash[ransomNote.charAt(i) - 'a']-- == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    void test1() {
        assertFalse(canConstruct("a", "b"));
    }

    @Test
    void test2() {
        assertFalse(canConstruct("aa", "ab"));
    }

    @Test
    void test3() {
        assertTrue(canConstruct("aa", "aab"));
    }
}
