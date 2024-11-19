package leetcode.problems.p02;

import leetcode.difficulty.Hard;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author zhanglei
 * @version 2024/11/19
 */
@Hard
public class P0212_Word_Search_II {
    @Test
    void test1() {
        Solution solution = new Solution1();
    }

    interface Solution {
        public List<String> findWords(char[][] board, String[] words);
    }

    class Solution1 implements Solution {
        @Override
        public List<String> findWords(char[][] board, String[] words) {
            return List.of();
        }
    }
}
