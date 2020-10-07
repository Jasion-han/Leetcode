#### [304. 二维区域和检索 - 矩阵不可变](https://leetcode-cn.com/problems/range-sum-query-2d-immutable/) + 矩阵不可变 + 小学记忆求矩阵法

难度：Median

### 解题思路

- 活脱脱小学数学思维题，很有回忆感，通过代码穿越一次童年吧~

### 代码

```java
class NumMatrix {

    // 创建二维数组存储某块矩形中所有元素之和
    private int[][] sum;
    
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        
        sum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 空出 0 的位置，计算当前横坐标下标为 i 和 纵坐标下标为 j 围城的一块矩形中所有元素之和
                sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] + matrix[i][j] - sum[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // 这里用到小学求矩形面积的巧妙解法: 为了求 aim 区域元素总和
        // 让这四块区域上的元素总和减去 a + c 的区域减去 a + b 的区域, 最后再加上 a 区域上的元素即可。
        //  ——————————
        // |  a |  b  |
        //  ——————————
        // |  c | aim |
        //  ——————————
        return sum[row2 + 1][col2 + 1] - sum[row2 + 1][col1] - sum[row1][col2 + 1] + sum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

作者：Jasion_han
链接：https://leetcode-cn.com/problems/range-sum-query-2d-immutable/solution/304-er-wei-qu-yu-he-jian-suo-ju-zhen-bu-ke-bian-xi/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

