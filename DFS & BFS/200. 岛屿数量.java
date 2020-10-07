#### [200. 岛屿数量](https://leetcode-cn.com/problems/number-of-islands/) + 递归寻找海域中相连岛屿的数量

难度：Median

### 解题思路

本题较好的使用 **递归法** 依次判断每块区域的位置

记录几点注意事项：

- 首先，定义 `4` 个方向的 **二维数组 ** `d` 这里使用的是 **数学上表示 **的上右下左顺序，而在一些题目中需要**特定的方向 **下需要参照 `79` 题的 **方向表示** (`79` 题不是特定情况，只是说明一种情况)
- 然后这里定义 `m` 和 `n` 的值因为全局都会用到，所以 **不能 **在判空前就赋值，不然 `[]` 这个测试用例过不去（亲测）
- 最后在 `dfs` 的 `if` 判断中的顺序问题，三个 `&&` 实则全真才真，一假全假，必须要 **先判断合法性 **再判断另外两个

### 代码

解法一：

```java
class Solution {        
    // 按照数学中的上右下左顺序表示，但不是计算机中的表示方法    
    private int d[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m, n;
    private boolean visited[][];
    
    public int numIslands(char[][] grid) {
        
        // 这里 m 和 n 不能写在判断之前
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
       
        visited = new boolean[m][n];
        
        // 记录岛屿的数量
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果该位置是一块岛屿并且之前没访问过
                if (grid[i][j] == '1' && !visited[i][j]) {
                    cnt++;
                    // 递归遍历下一块区域
                    dfs(grid, i, j);                    
                }
            }
        }
        return cnt;
    }
    
    private void dfs(char[][] grid, int x, int y) {
        
        // 先将当前访问区域锁定
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            // 错误顺序：grid[newX][newY] == '1' && !visited[newX][newY] && legal(newX, newY)
            // 必须先判断合法才能判断后面的
            if (legal(newX, newY) && grid[newX][newY] == '1' && !visited[newX][newY]) {
                dfs(grid, newX, newY);
            }
        }
        return;
    }
    
    private boolean legal(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n; 
    }
}
```

解法二：

```java
class Solution {
    
    private int m;
    private int n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        if (m == 0) {
            return 0;
        }
        n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    // dfs 寻找相邻的陆地所构成的岛屿
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }
    
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') {
            return;
        }
        
        // 防止重复遍历
        grid[i][j] = '*';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/number-of-islands/solution/20200414200mediandi-gui-xun-zhao-hai-yu-zhong-xian/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

