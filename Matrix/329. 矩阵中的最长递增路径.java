#### [329. 矩阵中的最长递增路径](https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/) + DFS，记忆化搜索

难度：Hard

### 解题思路

- 本题是个 `DFS` 和 **记忆化** 结合的题目
- 通过不断遍历当前元素的 **四个坐标方向** 进而寻找出一条 **递增的路径**
- 通过最大值比较，选出最长的路径即可。

### 代码

```java
class Solution {
    // 创建四个坐标
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        
        // 创建记忆化数组
        int[][] memo = new int[m][n];
        
        int ans = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // dfs 求最大增长递增路径
                int max = dfs(matrix, i, j, m, n, memo);
                ans = Math.max(ans, max);
            }
        }
        return ans;
    }
    
    // dfs
    private int dfs(int[][] matrix, int i, int j, int m, int n, int[][] memo) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        
        int max = 1;
        // 遍历坐标轴四个方向
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            // 如果新方向的 x 和 y 越界或者值不大于原来的,则换方向
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) {
                continue;
            }
            // 找到一个递增数字就将 len + 1
            int len = 1 + dfs(matrix, x, y, m, n, memo);
            max = Math.max(max, len);
        }
        // 更新记忆的最大值
        memo[i][j] = max;
        return max;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/solution/329-ju-zhen-zhong-de-zui-chang-di-zeng-lu-jing-dfs/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

