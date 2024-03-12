package com.code.basic.algorithm.dynamicprogramming;

/**
 * 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * <p>
 * 示例 2：
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 *
 * @author FengDuo
 * @date 2024/03/12 15:12
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        // f(x) = f(x-1) + f(x-2)
        int a = 0, b = 0, count = 1;
        for (int i = 1; i <= n; i++) {
            // f(x-1)
            a = b;
            // f(x-2)
            b = count;
            // f(x)
            count = a + b;
        }
        return count;
    }
}
