#### [79. 单词搜索](https://leetcode-cn.com/problems/word-search/) + 递归+回溯查找目标单词

难度：Median

### 解题思路

本题考虑的 **细节较多**，具体可以看注释处

- 一开始，我们需要设置几个 **全局变量**，因为后面有多个方法体会用到该变量
- 这里循环对横坐标和纵坐标进行 **上右下左 **的顺序进行遍历，找到目标值则继续遍历，若没有找到则 **更换方向 **寻找
- 若找到合适的元素则进行再一次的判断，即当前寻找到的新的元素 **是否越界**，**是否之前被访问过**，以及 **是否可递归 **进而返回 `true` 或 `false`
- 最后别忘了 **回退 **上一步方便 **回溯 **继续遍历

### 代码

解法一：

```java
class Solution {
    
    private boolean[][] visited;
    int m, n;
    // 记录四个方向(上右下左),比如第一组是向上移动即 x - 1，而 y 不动，以此类推
    int[][] d = {{-1, 0},{0, 1},{1, 0},{0, -1}};
    
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) {
            return false;
        }
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 递归搜索
                if (searchWord(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean searchWord(char[][] board, String word, int index, int x, int y) {
        if (index == word.length() - 1) {
            return board[x][y] == word.charAt(index);
        }
        if (board[x][y] == word.charAt(index)) {
            visited[x][y] = true;
            // 从 4 个方向搜索
            for (int i = 0; i < 4; i++) {
                int newX = x + d[i][0];
                int newY = y + d[i][1];
                // 如果 newX newY 位置合法，且未被访问过，然后递归下去遍历观察
                if (legal(newX, newY) && !visited[newX][newY] &&
                    searchWord(board, word, index + 1, newX, newY)) {
                    return true;
                }
            }
            // 上一步操作完后要恢复原始标记
            visited[x][y] = false;  
        }
        return false;
    }
    
    // 判断新的值 newX newY 是否越界
    private boolean legal(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
```

解法二：

```java
class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        if (word == null || word.length() == 0) {
            return true;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果找到 word 的第一个字母
                if (board[i][j] == word.charAt(0)) {
                    // 再进行 dfs 找之后的字母,成功找到所有字母才返回 true
                    // 有一个字母不满足就遍历其他位置的元素
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        // 所有元素遍历完都没找到就返回 false
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        // 找到所有的字母则返回 true
        if (index == word.length()) {
            return true;
        }
        // 如果越界或者找到的不匹配返回 false 再去其他方向找
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        // 找到有相同的字母，先随便用个符号标记该位置，以免重复使用
        board[i][j] = '*';
        // 然后再在四个方向找之后的字母
        boolean ans = dfs(board, word, i + 1, j, index + 1) ||
                      dfs(board, word, i - 1, j, index + 1) ||
                      dfs(board, word, i, j + 1, index + 1) ||
                      dfs(board, word, i, j - 1, index + 1);
        // 遍历完一趟后要恢复之前标记的字母位置,因为下一趟又是新的一次遍历,不会重复
        board[i][j] = word.charAt(index);
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/word-search/solution/2020042379mediandi-gui-hui-su-cha-zhao-mu-biao-dan/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

