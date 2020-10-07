#### [59. 螺旋矩阵 II](https://leetcode-cn.com/problems/spiral-matrix-ii/) + 顺时针递增的放入数字

难度：Median

### 解题思路

本题是 `54` 题的变形，主要使用方阵存放数字，那么就要按照顺时针的顺序递增的放入 `ans` 中

### 代码

```java
class Solution {
    public int[][] generateMatrix(int n) {
        // 创建结果数组,数组大小为输入的数字,即 n 行 n 列的矩阵
        int[][] ans = new int[n][n];
        if (n == 0) {
            return ans;
        }
        
        // 定义第一行,最后一行,第一列,最后一列
        int rowBegin = 0;
        int rowEnd = n - 1;
        int cowBegin = 0;
        int cowEnd = n - 1;
        // 初始化要填入的数字
        int num = 1;
        
        while (rowBegin <= rowEnd && cowBegin <= cowEnd) {
            // →
            for (int i = cowBegin; i <= cowEnd; i++) {
                // 按照螺旋的顺序递增的放入 num (下同)
                ans[rowBegin][i] = num;
                num++;
            }
            rowBegin++;
            
            // ↓
            for (int i = rowBegin; i <= rowEnd; i++) {
                ans[i][cowEnd] = num;
                num++;
            }
            cowEnd--;
            
            // ←
            for (int i = cowEnd; i >= cowBegin; i--) {
                ans[rowEnd][i] = num;
                num++;
            }
            rowEnd--;
            
            // ↑
            for (int i = rowEnd; i >= rowBegin; i--) {
                ans[i][cowBegin] = num;
                num++;
            }
            cowBegin++;
        }
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/spiral-matrix-ii/solution/59-luo-xuan-ju-zhen-ii-shun-shi-zhen-di-zeng-de-fa/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

