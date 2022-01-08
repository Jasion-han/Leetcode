#### [746. 使用最小花费爬楼梯](https://leetcode-cn.com/problems/min-cost-climbing-stairs/) + Bottom-up DP问题

难度：Easy

### 解题思路

- 由于前两步可选其一即可，那只需比较到达前两步的台阶谁有更小的开销，最后再加上到达当前台阶的开销即为最终最小开销。

- 状态转移方程不难写出：`dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];`

优化：

- 观察得知，本题 `dp` 使用情况和 `cost` 数组基本一样，那不妨直接用 `cost` 数组来表示，空间复杂度可降为 `O(1)`，固有下面的方法二。

### 代码

方法一：

```java
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            // 比较到达前两步的开销，最后再加上到达当前台阶的开销
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
        }
        // 最后只需比较到达最后两步分别的开销谁更小即可
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}
```

方法二：

```java
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] = Math.min(cost[i - 2], cost[i - 1]) + cost[i];
        }
        return Math.min(cost[cost.length - 2], cost[cost.length - 1]);
    }
}
```