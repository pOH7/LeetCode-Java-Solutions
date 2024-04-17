package leetcode.problems.p00;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 59. Spiral Matrix II
 *
 * @link https://leetcode.com/problems/spiral-matrix-ii/
 * @author zhanglei
 * @date 2022/2/23
 */
@Slf4j
class P0059 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int k = 1;
        int i = 0;
        int j = 0;
        int d = 0;
        result[i][j] = k++;
        while (k <= n * n) {
            int[] nextijd = nextijd(result, i, j, d);
            i = nextijd[0];
            j = nextijd[1];
            d = nextijd[2];
            result[i][j] = k++;
        }
        return result;
    }

    static int[] nextijd(int[][] result, int i, int j, int d) {
        int nexti = i;
        int nextj = j;
        int nextd = d;
        switch (d) {
            case 0: // go right
                if (j == result.length - 1 || result[i][j + 1] != 0) {
                    nexti = i + 1;
                    nextd = 1;
                } else {
                    nextj = j + 1;
                }
                break;
            case 1: // go down
                if (i == result.length - 1 || result[i + 1][j] != 0) {
                    nextj = j - 1;
                    nextd = 2;
                } else {
                    nexti = i + 1;
                }
                break;
            case 2: // go left
                if (j == 0 || result[i][j - 1] != 0) {
                    nexti = i - 1;
                    nextd = 3;
                } else {
                    nextj = j - 1;
                }
                break;
            case 3: // go up
                if (i == 0 || result[i - 1][j] != 0) {
                    nextj = j + 1;
                    nextd = 0;
                } else {
                    nexti = i - 1;
                }
                break;
        }
        return new int[] {nexti, nextj, nextd};
    }

    @Test
    void test1() {
        Assertions.assertEquals(
                "[[1, 2, 3],[8, 9, 4],[7, 6, 5]]",
                Arrays.stream(generateMatrix(3))
                        .map(Arrays::toString)
                        .collect(Collectors.joining(",", "[", "]")));
    }

    @Test
    void test2() {
        Assertions.assertEquals(
                "[[1]]",
                Arrays.stream(generateMatrix(1))
                        .map(Arrays::toString)
                        .collect(Collectors.joining(",", "[", "]")));
    }
}
