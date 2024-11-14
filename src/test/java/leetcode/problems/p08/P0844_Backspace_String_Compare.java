package leetcode.problems.p08;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * @author zhanglei
 * @version 2024/11/14
 */
public class P0844_Backspace_String_Compare {
    @Test
    void test1() {
        Solution solution = new Solution1();
        assertTrue(solution.backspaceCompare("ab#c", "ad#c"));
    }

    @Test
    void test2() {
        Solution solution = new Solution1();
        assertTrue(solution.backspaceCompare("ab##", "c#d#"));
    }

    @Test
    void test3() {
        Solution solution = new Solution1();
        assertFalse(solution.backspaceCompare("a#c", "b"));
    }

    @Test
    void test4() {
        Solution solution = new Solution1();
        assertTrue(solution.backspaceCompare("##c", "c"));
    }

    interface Solution {
        public boolean backspaceCompare(String s, String t);
    }

    class Solution1 implements Solution {
        @Override
        public boolean backspaceCompare(String s, String t) {
            int si = s.length() - 1;
            int ti = t.length() - 1;
            int bs = 0;
            while (si >= 0 || ti >= 0) {
                if (si >= 0) {
                    if (s.charAt(si) == '#') {
                        si--;
                        bs = 1; // reset backspace
                        while (si >= 0 && bs > 0 || si >= 0 && s.charAt(si) == '#') {
                            if (s.charAt(si) == '#') {
                                si--;
                                bs++;
                            } else {
                                si--;
                                bs--;
                            }
                        }
                    }
                }
                if (ti >= 0) {
                    if (t.charAt(ti) == '#') {
                        ti--;
                        bs = 1;
                        while (ti >= 0 && bs > 0 || ti >= 0 && t.charAt(ti) == '#') {
                            if (t.charAt(ti) == '#') {
                                ti--;
                                bs++;
                            } else {
                                ti--;
                                bs--;
                            }
                        }
                    }
                }
                if (si >= 0 && ti >= 0) {
                    if (s.charAt(si) == t.charAt(ti)) {
                        si--;
                        ti--;
                    } else {
                        return false;
                    }
                } else if (si < 0 && ti < 0) {
                    return true;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}
