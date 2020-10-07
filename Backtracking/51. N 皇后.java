#### [51. N 皇后](https://leetcode-cn.com/problems/n-queens/) + 回溯法寻找 N皇后 真身

难度: Hard

### 解题思路

**各位小伙伴 `5.1` 快乐，刚好今天要刷第 `51` 题是不是有点巧呢哈哈，来体会一下 N皇后 算法支配的力量吧！**

本题使用 **回溯法** 寻找棋盘中皇后藏身之地

- 要想寻找棋盘上所有的皇后，得从多个角度去遍历寻找，根据题目要求每行每列主副对角线不得有多个皇后

- 那么我们就定义列，主副对角线数组来记录遍历到当前元素下的三个方向是否有第二个皇后
- 然后要清楚知道 `n × n` 的棋盘上 **对角线数 **为 `2 * n - 1`
- 接下来就是利用 **递归 + 回溯** 的思想挨个遍历每行当中符合要求的位置，当遍历到最后一行即找到了一组解，将其放入 `row`  中存储，然后再通过 `changeBoard` 方法将找出来的位置转化为 **棋盘格形式** 存储，并放入 `ans` 结果集中
- 这样遍历完所有元素之后就会找到所有满足要求的解返回 `ans` 即可。

### 代码

解法一：

```java
class Solution {
    // 定义列和主副对角线
    private boolean[] col;
    private boolean[] dia1;
    private boolean[] dia2;
    private List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        col = new boolean[n];
        // 对角线个数为 2 * n - 1
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];

        // 定义每行的元素个数
        List<Integer> row = new LinkedList<>();
        // 回溯寻找符合要求的每组解
        putQueen(n, 0, row);
        return ans;
    }

    // index 代表当前访问的行数,最多到 n; row 用来存放满足题意的一种情况
    private void putQueen(int n, int index, List<Integer> row) {
        // 如果遍历到了最后一行，即代表已经找出一组解出来
        if (index == n) {
            // 将找到的一组解转化为棋盘格的形式后再放入 ans
            ans.add(changeBoard(n, row));
            return;
        }
        // 遍历当前 index 行的所有位置(从前往后依次遍历)
        for (int i = 0; i < n; i++) {
            // index + i 表示横纵坐标相加
            // index - i + n - 1 表示横纵坐标之差
            // 如果当前位置元素与他同一列，同一主副对角线上没有重复元素
            if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {
                // 则该位置即皇后放置的位置，放入 row 存储位置信息，并标记为 true
                row.add(i);
                // 此时在该元素所在的列和主副对角线上就不能在遍历找到其他元素了
                // 即标记为 true
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;

                // 接着递归寻找下一行
                putQueen(n, index + 1, row);

                // 遍历完后再退出标记
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
                // 回退上一格子(回溯)
                row.remove(row.size() - 1);
            }
        }
        return;
    }

    // 将找到的一组解转化为棋盘格形式存储
    private List<String> changeBoard(int n, List<Integer> row) {
        List<String> tmp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] ch = new char[n];
            // 初始化 ch 中所有位置元素为 ‘.’
            Arrays.fill(ch, '.');
            // 将 row 中已经确定下来的 Queen 位置改为 ‘Q’
            ch[row.get(i)] = 'Q';
            // 然后放入 tmp 中
            tmp.add(new String(ch));
        }
        return tmp;
    }
}
```

解法二：

```java
class Solution {
    
    Set<Integer> col = new HashSet<>();
    Set<Integer> diff = new HashSet<>();
    Set<Integer> sum = new HashSet<>();
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        if (n < 1) {
            return ans;
        }
        char[][] board = new char[n][n];
        // 初始化棋盘为空位
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '.');
        }
        dfs(n, ans, board, 0);
        return ans;
    }
    
    private void dfs(int n, List<List<String>> ans, char[][] board, int level) {
        if (level == n) {
            // 注意这里创建 tmp 来接收每行中的皇后位置
            List<String> tmp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                tmp.add(String.valueOf(board[i]));
            }
            ans.add(tmp);
        }
        for (int i = 0; i < n; i++) {
            // 如果行,主副对角线均没有皇后
            if (!col.contains(i) && !diff.contains(level - i) && !sum.contains(level + i)) {
                col.add(i);
                diff.add(level - i);
                sum.add(level + i);
                board[level][i] = 'Q';
                // 递归遍历下一层
                dfs(n, ans, board, level + 1);
                // 以下恢复原有的样子
                board[level][i] = '.';
                col.remove(i);
                diff.remove(level - i);
                sum.remove(level + i);
            }
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/n-queens/solution/2020050151hardhui-su-fa-xun-zhao-nhuang-hou-zhen-s/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

