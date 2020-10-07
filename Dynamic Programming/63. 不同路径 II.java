#### [63. 不同路径 II](https://leetcode-cn.com/problems/unique-paths-ii/) + 解决路障问题

难度：Median

### 解题思路

本题是 `62` 题的升级版，加上了 **路障**，但依旧是使用 **动态规划** 解决问题

首先对特殊情况判断是否满足题意，如果满足就将开始位置的值设为 `1`，之后只需访问到终点前一个位置（上或左）即可。

然后对数组进行双重循环，当遇到路障的时候就 `continue`，进行下一轮寻找

如果 `i > 0`，即 **从上往下的路径数**。如果 `j > 0`，即 **从左往右的路径数**

最终返回终点位置即可。

### 代码

解法一：

```java
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        //特殊情况判断
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1){
            return 0;
        }
        dp[0][0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(obstacleGrid[i][j] == 1){//遇到障碍就进行下一轮寻找
                    continue;
                }
                if(i > 0){
                    dp[i][j] += dp[i - 1][j];//从上过来的路径数
                }
                if(j > 0){
                    dp[i][j] += dp[i][j - 1];//从左过来的路径数
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
```

解法二：

```java
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int len = obstacleGrid[0].length;
        int[] dp = new int[len];
        // 将第一列可到达的路径数初始化为 1
        dp[0] = 1;
        
        // 因为有障碍物，所以要遍历所有位置
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < len; j++) {
                // 如果遇见障碍物
                if (obstacleGrid[i][j] == 1) {
                    // 就初始化可到达路径数为 0
                    dp[j] = 0;
                // 如果不在第一列即 j > 0 那么 dp[j - 1] 才有效
                } else if (j > 0) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }
        return dp[len - 1];
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/unique-paths-ii/solution/2020031663median-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

