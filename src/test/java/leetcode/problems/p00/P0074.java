package leetcode.problems.p00;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * @link https://leetcode.com/problems/search-a-2d-matrix/
 * @author zhanglei
 * @date 2021/12/8
 */
public class P0074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int end = rows * cols - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            int midVal = matrix[mid / cols][mid % cols];
            if (midVal == target) {
                return true;
            } else if (midVal > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    @Test
    void test() {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        assertTrue(searchMatrix(matrix, 3));
    }
}
