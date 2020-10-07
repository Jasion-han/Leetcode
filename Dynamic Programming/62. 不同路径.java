#### [62. 不同路径](https://leetcode-cn.com/problems/unique-paths/) + 拆分成子问题解决

难度：Median

### 解题思路

本题使用 **动态规划（dp）**解题

动态方程很重要：`dp[i][j] = dp[i - 1][j] + dp[i][j - 1]`

这里还优化了下，用一个数组来完成，主要思想是用上一行求出的 `j` 加上当前行的 `j - 1` 即为最终路径

又因为右下角终点位置只能由他 **上边** 或 **左边** 的 **一个方向** 到达，故初始化他们值都为 `1` 即可。

### 代码

```java
class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        // 初始化第一列的值全为 1
        dp[0] = 1;
        
        // 从第二列开始遍历每行的位置
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 后面的 dp[j] 是同一列上面位置的值
                // dp[j - 1] 是同一行左边位置的值
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/unique-paths/solution/2020031662median-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



