#### [52. N皇后 II](https://leetcode-cn.com/problems/n-queens-ii/) + 回溯法寻找 N皇后 摆放个数

难度：Hard

### 解题思路

本题和上一题 `51` 有着 **很多相似之处**，并且本题还要稍微简单些

- 在与上一题的 **差异** 中，本题更换了一个记录行数的 `list`，换用 `cnt` 来代之求解 N皇后 不同解法的个数
- 在递归方法体中，出口条件由原来的行数转化为棋盘格形式后存储变为了 **计数器 ++**
- 并且在循环体内，只需要将遍历过的位置进行标记，再进行递归，而后恢复标记进行下一轮循环

- 至此，就完成了求解 `N`皇后 不同摆法的解的个数。

### 代码

解法一：

```java
class Solution {
    private boolean[] col;
    private boolean[] dia1;
    private boolean[] dia2;
    private int cnt;
    public int totalNQueens(int n) {
        if (n <= 0) {
            return cnt;
        }
        col = new boolean[n];
        // 对角线个数为 2 * n - 1
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        
        // 回溯计算符合要求的解的个数
        countQueen(n, 0);
        return cnt;
    }
    
    // index 代表当前访问的行数,最多到 n
    private void countQueen(int n, int index) {
        // 如果遍历到了最后一行，即代表已经找出一组解出来，计数器++
        if (index == n) {
            cnt++;
            return;
        }
        // 遍历当前 index 行的所有位置(从前往后依次遍历)
        for (int i = 0; i < n; i++) {
            // index + i 表示横纵坐标相加
            // index - i + n - 1 表示横纵坐标之差
            // 如果当前位置元素与他同一列，同一主副对角线上没有重复元素
            if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {

                // 此时在该元素所在的列和主副对角线上就不能在遍历找到其他元素了
                // 即标记为 true
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;
                
                // 接着递归寻找下一行
                countQueen(n, index + 1);
                
                // 遍历完后再退出标记
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
            }
        }
        return;
    }
}
```

解法二：

```java
class Solution {
    
    private int ans = 0;
    Set<Integer> col = new HashSet<>();
    Set<Integer> diff = new HashSet<>();
    Set<Integer> sum = new HashSet<>();
    
    public int totalNQueens(int n) {
        if (n < 1) {
            return ans;
        }
        dfs(n, 0);
        return ans;
    }
    
    private void dfs(int n, int level) {
        if (level == n) {
            ans++;
            return;
        }
        // 遍历每一行(保证了不同行)
        for (int i = 0; i < n; i++) {
            // 非同一列，非主斜对角每个元素的差相等，非副对角线每个元素的和相等
            if (!col.contains(i) && !diff.contains(level - i) && !sum.contains(level + i)) {
                
                col.add(i);
                diff.add(level - i);
                sum.add(level + i);
                
                dfs(n, level + 1);
                
                col.remove(i);
                diff.remove(level - i);
                sum.remove(level + i);
            }
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/n-queens-ii/solution/2020050352hardhui-su-fa-xun-zhao-nhuang-hou-bai-fa/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

