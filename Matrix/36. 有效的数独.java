#### [36. 有效的数独](https://leetcode-cn.com/problems/valid-sudoku/) + 分别遍历行列块

难度：Median

### 解题思路

- 本题分别对 **每行**，**每列**，**`9` 个格子** 进行遍历
- 为了不重复遍历，创建 isSeen 数组进行判断，若有重复则直接跳到下一轮，若没有则返回 `true`

- 这里要注意遍历九宫格的时候如和取值

### 代码

解法一：

```java
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        // 对每行进行遍历
        for (int row = 0; row < 9; row++) {
            boolean[] isSeen = new boolean[9];
            for (int idx = 0; idx < 9; idx++) {
                char c = board[row][idx];
                if (c != '.') {
                    int num = c - '1';
                    // 如果之前遍历的时候出现过该数字说明有重复，不满足所以跳到下一轮循环
                    if (isSeen[num] == true) {
                        return false;
                    } else {
                        isSeen[num] = true;
                    }
                }
            }
        }

        // 对每列进行遍历
        for (int col = 0; col < 9; col++) {
            boolean[] isSeen = new boolean[9];
            for (int idx = 0; idx < 9; idx++) {
                char c = board[idx][col];
                if (c != '.') {
                    int num = c - '1';
                    if (isSeen[num] == true) {
                        return false;
                    } else {
                        isSeen[num] = true;
                    }
                }
            }
        }

        // 对每个格子进行遍历
        for (int box = 0; box < 9; box++) {
            boolean[] isSeen = new boolean[9];
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    // 注意取值方法(可以手动计算或记忆)
                    char c = board[row + 3 * (box / 3)][col + 3 * (box % 3)];
                    if (c != '.') {
                        int num = c - '1';
                        if (isSeen[num] == true) {
                            return false;
                        } else {
                            isSeen[num] = true;
                        }
                    }
                }
            }
        }
        return true;
    }
}
```



解法二：

```java
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> ans = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    // 这里是说如果某行或某列或某个格子在 set 里面已经有相同数字则重复不满足题意
                    if (!ans.add(num + "inRow" + i) ||
                        !ans.add(num + "inCol" + j) ||
                        !ans.add(num + "inBlock" + i / 3 + "-" + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/valid-sudoku/solution/36-you-xiao-de-shu-du-fen-bie-bian-li-xing-lie-kua/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

