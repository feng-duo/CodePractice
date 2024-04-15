package com.code.basic.algorithm.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * @author FengDuo
 * @date 2024/04/15 16:08
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        // 上下左右4个边界值
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        ArrayList<Integer> numList = new ArrayList<>();

        while (true) {
            // 从左往右，上边界收缩
            for (int i = left; i <= right; i++) {
                numList.add(matrix[top][i]);
            }
            if (++top > bottom) break;
            // 从上往下，右边界收缩
            for (int i = top; i <= bottom; i++) {
                numList.add(matrix[i][right]);
            }
            if (left > --right) break;
            // 从右往左，下边界收缩
            for (int i = right; i >= left; i--) {
                numList.add(matrix[bottom][i]);
            }
            if (top > --bottom) break;
            // 从下往上，左边界收缩
            for (int i = bottom; i >= top; i--) {
                numList.add(matrix[i][left]);
            }
            if (++left > right) break;
        }

        return numList;
    }
}
