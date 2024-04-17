package leetcode.problems.p22;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 剑指 Offer 05. 替换空格
 *
 * @link https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * @author zhanglei
 * @date 2022/2/25
 */
class P2239 {

    /*
    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }
    */

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    @Test
    void test1() {
        assertEquals("We%20are%20happy.", replaceSpace("We are happy."));
    }
}
