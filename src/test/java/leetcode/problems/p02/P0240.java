package leetcode.problems.p02;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * @link https://leetcode.com/problems/search-a-2d-matrix-ii/
 * @author zhanglei
 * @date 2021/12/8
 */
public class P0240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }

    //    public boolean searchMatrix(int[][] matrix, int target) {
    //        return searchMatrix(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, target);
    //    }
    //
    //    private boolean searchMatrix(
    //            int[][] matrix, int row1, int col1, int row2, int col2, int target) {
    //        if (row1 > row2 || col1 > col2) {
    //            return false;
    //        }
    //        int row3 = (row1 + row2) >>> 1;
    //        int col3 = (col1 + col2) >>> 1;
    //        if (matrix[row3][col3] == target) {
    //            return true;
    //        } else if (matrix[row3][col3] > target) {
    //            return searchMatrix(matrix, row1, col1, row3 - 1, col2, target)
    //                    || searchMatrix(matrix, row1, col1, row2, col3 - 1, target);
    //        } else {
    //            return searchMatrix(matrix, row3 + 1, col1, row2, col2, target)
    //                    || searchMatrix(matrix, row1, col3 + 1, row2, col2, target);
    //        }
    //    }

    @Test
    void test() {
        int[][] matrix = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        assertTrue(searchMatrix(matrix, 5));
    }
}
