package com.algorithm.dp;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 *
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 *
 *
 * 提示：
 *
 * 1 <= n <= 45
 * @author GF
 * @since 2023/7/31
 */
public class A0070ClimbingStairs2 {

    /**
     * 额外空间复O(n)
     */
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[n];
    }

    public int climbStairs2(int n) {
        int a = 1, b = 2, c = 0;
        if (n == 1) {
            return a;
        } else if (n == 2) {
            return b;
        }
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        A0070ClimbingStairs2 algorithm = new A0070ClimbingStairs2();
        int ways = algorithm.climbStairs(10);
        System.out.println(ways);
        System.out.println(algorithm.climbStairs2(10));
    }

}
