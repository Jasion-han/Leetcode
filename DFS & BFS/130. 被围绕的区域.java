#### [130. 被围绕的区域](https://leetcode-cn.com/problems/surrounded-regions/) + DFS 寻找被围绕的区域

难度：Median

### 解题思路

本题与 `200` 题有相似之处，以下说明区别：

- 首先 **判空 **和定义 **行和列**

- 然后遍历二维矩阵的 **四个边界**，若边界有 `O` 或者有有与边界 `O` 相连的 `O`，那么都将他们先转成 `P` 存储
- 遍历完四面边界元素后，此时 **不满足题意** 的 `O` 都被标记成了 `P`，而所有被 `X` 包围的 `O` 还是哪个 `O`
- 那么只需将现在的 `O` 再转成 `X`， 所有的 `P` 再转成 `O` 即可完成填充任务。

### 代码

解法一：

```java
class Solution {
    
    private int[][] d = {{-1, 0},{0, 1},{1, 0},{0, -1}};
    private int m, n;
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        m = board.length;
        n = board[0].length;
        
        // 将边界位置的 O 都换成 P
        for (int i = 0; i < m; i++) {
            // 遍历第一列
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            // 遍历最后一列
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }
        
        // 将边界位置的 O 都换成 P
        for (int j = 0; j < n; j++) {
            // 遍历第一行
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            // 遍历最后一行
            if (board[m - 1][j] == 'O') {
                dfs(board, m - 1, j);
            }
        }
        
        // 最后遍历完所有边界元素后，将元素复位
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'P') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void dfs(char[][] board, int x, int y) {
        // 若 O 在边界或和边界的 O 相连，则都换成 P
        board[x][y] = 'P';
        for (int i = 0; i < 4; i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            if (legal(newX, newY) && board[newX][newY] == 'O') {
                dfs(board, newX, newY);
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
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        m = board.length;
        n = board[0].length;
        // 遍历第一列和最后一列
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }
        // 遍历第一行和最后一行
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                dfs(board, m - 1, j);
            }
        }
        
        // 最后全盘扫描进行元素替换
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 要先执行这步再执行下面的
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (board[i][j] != 'O') {
            return;
        }
        // 将连接边界元素 o 的所有 o 都先转换成 #
        board[i][j] = '#';
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/surrounded-regions/solution/20200430130mediandfsxun-zhao-bei-wei-rao-de-qu-yu-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

