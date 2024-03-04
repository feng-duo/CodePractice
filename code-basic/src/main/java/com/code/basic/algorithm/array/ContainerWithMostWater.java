package com.code.basic.algorithm.array;

/**
 * 盛最多水的容器
 * <p>
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 *
 * @author FengDuo
 * @date 2024/03/04 22:36
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int area = 0, leftPointer = 0, rightPointer = height.length - 1;
        while (leftPointer < rightPointer) {
            area = Math.max(area, Math.min(height[leftPointer], height[rightPointer]) * (rightPointer - leftPointer));
            if (height[leftPointer] < height[rightPointer]) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }
        return area;
    }

/* 更优解

public int maxArea(int[] height) {
        int n=height.length;
        int i=0, j=n-1;
        int base=-1, res=-1;
        while (i < j) {
            base=Math.min(height[i], height[j]);
            res=Math.max(res, base * (j-i));
            while (i < j && height[i] <= base) i++;
            while (j > i && height[j] <= base) j--;
        }
        return res;
    }*/
}
