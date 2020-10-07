#### [74. 搜索二维矩阵](https://leetcode-cn.com/problems/search-a-2d-matrix/) + 二分法，矩阵求值除余大法

难度：Median

### 解题思路

- 本题和普通的二分搜索很相似
- 具体区别在于寻找矩阵中的 **最右边界索引**，求取 **矩阵中的数值** 写法

### 代码

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        // 二分法
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        // 注意此时的右边界写法
        int right = row * col - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            // 注意求矩阵中元素数值的写法
            int value = matrix[mid / col][mid % col];
            if (value == target) {
                return true;
            } else if (value < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        // 如果第一个或最后一个数是 target 则返回 true,否则返回 fasle
        if (matrix[left / col][left % col] == target) {
            return true;
        } else if (matrix[right / col][right % col] == target) {
            return true;
        }else {
            return false;
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/search-a-2d-matrix/solution/74-sou-suo-er-wei-ju-zhen-er-fen-fa-ju-zhen-qiu-zh/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

