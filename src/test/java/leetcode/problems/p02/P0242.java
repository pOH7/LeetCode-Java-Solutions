package leetcode.problems.p02;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * 242. Valid Anagram
 *
 * @link https://leetcode.com/problems/valid-anagram/
 * @author zhanglei
 * @date 2022/2/23
 */
class P0242 {

    public boolean isAnagram(String s, String t) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i) - 'a']--;
        }
        for (int i : hash) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    /*
    // not good
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>(26);
        for (int i = 0; i < s.length(); i++) {
            add(map, s.charAt(i));
        }
        for (int i = 0; i < t.length(); i++) {
            if (!remove(map, t.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    static void add(Map<Character, Integer> map, char c) {
        if (map.containsKey(c)) {
            map.put(c, map.get(c) + 1);
        } else {
            map.put(c, 1);
        }
    }

    static boolean remove(Map<Character, Integer> map, char c) {
        if (map.containsKey(c)) {
            Integer num = map.get(c);
            if (num == 1) {
                map.remove(c);
            } else {
                map.put(c, num - 1);
            }
            return true;
        } else {
            return false;
        }
    }
    */

    @Test
    void test1() {
        assertTrue(isAnagram("anagram", "nagaram"));
    }

    @Test
    void test2() {
        assertFalse(isAnagram("rat", "car"));
    }
}
