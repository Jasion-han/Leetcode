#### [73. 矩阵置零](https://leetcode-cn.com/problems/set-matrix-zeroes/) + 首行首列标志位

难度：Median

### 解题思路

本题主要给第 `0` 行和第 `0` 列设置标志位，分为几个步骤如下所示。

### 代码

```java
class Solution {
    public void setZeroes(int[][] matrix) {
        // 设置第 0 行和第 0 列为标志位
        boolean rowZero = false;
        boolean colZero = false;
        // 设置总共有 m 行, n 列
        int m = matrix.length;
        int n = matrix[0].length;
        // 扫描所有数字
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    // 如果第 0 行或第 0 列有 0,那么标志位设置为 true
                    if (i == 0) {
                        rowZero = true;
                    }
                    if (j == 0) {
                        colZero = true;
                    }
                    // 将出现 0 的位置所在行所在列的首位改为 0
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // 遍历第 0 行除第一个位置以外的其他位置
        for (int j = 1; j < n; j++) {
            // 若有 0,则对应整列改成 0
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // 遍历第 0 列除第一个位置以外的其他位置
        for (int i = 1; i < m; i++) {
            // 若有 0,则对应整行改成 0
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // 如果一开始第 0 行就有 0,那么整行改成 0
        if (rowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        // 如果一开始第 0 列就有 0,那么整列改成 0
        if (colZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/set-matrix-zeroes/solution/73-ju-zhen-zhi-ling-shou-xing-shou-lie-biao-zhi-we/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

