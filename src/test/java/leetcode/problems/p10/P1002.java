package leetcode.problems.p10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1002. Find Common Characters
 *
 * @link https://leetcode.com/problems/find-common-characters/
 * @author zhanglei
 * @date 2022/2/23
 */
class P1002 {
    public List<String> commonChars(String[] words) {
        int[] hash = new int[26];
        for (int j = 0; j < words[0].length(); j++) {
            hash[words[0].charAt(j) - 'a']++;
        }
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            int[] hash2 = new int[26];
            for (int j = 0; j < word.length(); j++) {
                hash2[word.charAt(j) - 'a']++;
            }
            for (int k = 0; k < 26; k++) {
                hash[k] = Math.min(hash[k], hash2[k]);
            }
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < hash.length; i++) {
            while (hash[i]-- > 0) {
                result.add(String.valueOf((char) ('a' + i)));
            }
        }
        return result;
    }

    @Test
    void test1() {
        String[] words = {"bella", "label", "roller"};
        assertEquals(Arrays.asList("e", "l", "l").toString(), commonChars(words).toString());
    }

    @Test
    void test2() {
        String[] words = {"cool", "lock", "cook"};
        assertEquals(Arrays.asList("c", "o").toString(), commonChars(words).toString());
    }
}
