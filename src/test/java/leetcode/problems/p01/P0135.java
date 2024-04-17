package leetcode.problems.p01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 135. Candy
 *
 * @link https://leetcode.com/problems/candy/
 * @author zhanglei
 * @date 2022/4/28
 */
class P0135 {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        candy[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            } else {
                candy[i] = 1;
            }
        }
        int result = candy[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i + 1] + 1, candy[i]);
            }
            result += candy[i];
        }
        return result;
    }

    @Test
    void test1() {
        int[] ratings = {1, 0, 2};
        assertEquals(5, candy(ratings));
    }

    @Test
    void test2() {
        int[] ratings = {1, 2, 2};
        assertEquals(4, candy(ratings));
    }
}
