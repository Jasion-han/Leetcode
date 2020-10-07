#### [64. 最小路径和](https://leetcode-cn.com/problems/minimum-path-sum/) + 从第一行第一列出发的两条路径

难度：Median

### 解题思路

- 因为只能 **横着走** 或者 **竖着走**
- 那么就分别从 **第一行** 和 **第一列** 开始走，走的时候进行最小值比较，最终选出的值就是最小值了。

### 代码

```java
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // 计算第一列
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        // 计算第一行
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        // 其他位置继续寻找较小者路径
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        // 返回最后所保留的最小总和
        return grid[m - 1][n - 1];
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/minimum-path-sum/solution/64-zui-xiao-lu-jing-he-cong-di-yi-xing-di-yi-lie-c/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

