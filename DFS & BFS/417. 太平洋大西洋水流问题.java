#### [417. 太平洋大西洋水流问题](https://leetcode-cn.com/problems/pacific-atlantic-water-flow/) + DFS 寻找流向太平洋和大西洋的坐标

难度：Median

### 解题思路

本题和 `200` 题很相似，以下说明区别：

- 这里需要定义一个 `ans` 来存放最后的目标坐标
- 然后需要定义 **两个洋 **的数组，来定义 **上边界和右边界 **一组，**左边界和下边界 **为一组进行遍历
- 然后使用 **逆流思维**，从低处往高处遍历，直到两数组寻找到 **同一坐标** 即可放入 `ans` 作为最终结果

### 代码

```java
class Solution {
    
    private int[][] d = {{-1, 0},{0, 1},{1, 0},{0, -1}};
    private int m, n;
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        m = matrix.length;
        n = matrix[0].length;
        // 太平洋
        int[][] pacific = new int[m][n];
        // 大西洋
        int[][] atlantic = new int[m][n];
        
        // 递归遍历四个边界，并存放到对应的数组中
        for (int i = 0; i < n; i++) {
            // 上边界
            dfs(matrix, 0, i, pacific);
            // 右边界
            dfs(matrix, m - 1, i, atlantic);
        }
        for (int i = 0; i < m; i++) {
            // 左边界
            dfs(matrix, i, 0, pacific);
            // 下边界
            dfs(matrix, i, n - 1, atlantic);
        }
        
        // 最后遍历完所有边界值，将选出的目标坐标放入 ans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    ans.add(Arrays.asList(i, j));
                }                
            }
        }
        return ans;
    }
    
    private void dfs(int[][] matrix, int x, int y, int[][] tmp) {
        tmp[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            // 这里使用 或 的形式，如果是 与 的形式会少解 [1,4]
            if (!legal(newX, newY) || matrix[x][y] > matrix[newX][newY] || tmp[newX][newY] == 1) {
                continue;
            }
            dfs(matrix, newX, newY, tmp);
        }
    }
    
    private boolean legal(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/pacific-atlantic-water-flow/solution/20200430417mediandfsxun-zhao-liu-xiang-tai-ping-ya/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

