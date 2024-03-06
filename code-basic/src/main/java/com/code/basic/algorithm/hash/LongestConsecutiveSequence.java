package com.code.basic.algorithm.hash;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 最长连续序列
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * @author FengDuo
 * @date 2024/03/02 11:42
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        longestConsecutive(nums);
    }

    public static int longestConsecutive(int[] nums) {
        int length = nums.length;
        if (length == 0 || length == 1) {
            return length;
        }
        List<Integer> list = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
        int count = 1, temp, max= 0;
        for (int i = 1; i < list.size(); i++) {
            temp = list.get(i) - list.get(i - 1);
            if (temp == 1) {
                count++;
            } else if (temp > 1){
                max = Math.max(count, max);
                count = 1;
            }
        }
        return Math.max(count, max);
    }
}
