#### [221. 最大正方形](https://leetcode-cn.com/problems/maximal-square/) + 三方位寻找最小构成正方形的数目

难度：Median

### 解题思路

- 二维动态规划问题，主要考虑当前点的 **正上方**，**左方**，**左斜上方** 进行比较选出能构成正方形的最小数目再 `+ 1`

- 即必须要满足再加入更多节点也能构成正方形才算数。

### 代码

```java
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int ans = 0;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    // 在当前点的正上方，左方，左斜上方进行比较选出能构成正方形的最小数目再 + 1
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans * ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/maximal-square/solution/221-zui-da-zheng-fang-xing-san-fang-wei-xun-zhao-z/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

