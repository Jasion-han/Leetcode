#### [240. 搜索二维矩阵 II](https://leetcode-cn.com/problems/search-a-2d-matrix-ii/) + 右上角出发按顺序搜索

难度：Median

### 解题思路

- 本题考虑重点是从 **最右上角** 的元素开始找
- 如果这个元素比 `target` 大，则说明找 **更小** 的，**往左走** 以降序查找
- 如果这个元素比 `target` 小，则说明应该找 **更大** 的，**往下走** 以升序查找
- 如果在某个点相等了，就说明找到了，返回 `true`

- 如果一直走直到出矩阵边界了还没找到，则说明不存在，返回 `false`。

### 代码

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // 起点设置为最右上角的元素
        int curRow = 0;
        int curCol = n - 1;
        while (curRow < m && curCol >= 0) {
            if (matrix[curRow][curCol] == target) {
                return true;
            } else if (matrix[curRow][curCol] < target) {
                curRow++;
            } else {
                curCol--;
            }
        }
        // 走出边界了还没找到,说明不存在,返回false
        return false;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/solution/240-sou-suo-er-wei-ju-zhen-ii-you-shang-jiao-chu-f/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

