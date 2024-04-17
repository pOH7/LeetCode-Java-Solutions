package leetcode.problems.p00;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. Restore IP Addresses
 *
 * @link https://leetcode.com/problems/restore-ip-addresses/
 * @author zhanglei
 * @date 2022/4/14
 */
class P0093 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        restoreIpAddresses(s, 0, new ArrayList<>(), result);
        return result;
    }

    void restoreIpAddresses(String s, int index, List<String> temp, List<String> result) {
        if (index == s.length() && temp.size() == 4) {
            result.add(String.join(".", temp));
        } else if (temp.size() < 4) {
            for (int i = index; i < s.length() && i <= index + 2 && isValid(s, index, i); i++) {
                String a = s.substring(index, i + 1);
                temp.add(a);
                restoreIpAddresses(s, i + 1, temp, result);
                temp.remove(temp.size() - 1);
            }
        }
    }

    boolean isValid(String s, int start, int end) {
        int i = Integer.parseInt(s.substring(start, end + 1));
        return i >= 0 && i <= 255 && (end == start || s.charAt(start) != '0');
    }

    @Test
    void test1() {
        assertEquals(
                "[255.255.11.135, 255.255.111.35]", restoreIpAddresses("25525511135").toString());
    }

    @Test
    void test2() {
        assertEquals("[0.0.0.0]", restoreIpAddresses("0000").toString());
    }

    @Test
    void test3() {
        assertEquals(
                "[1.0.10.23, 1.0.102.3, 10.1.0.23, 10.10.2.3, 101.0.2.3]",
                restoreIpAddresses("101023").toString());
    }
}
