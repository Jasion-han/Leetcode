#### [378. 有序矩阵中第K小的元素](https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/) + 二分法，左下角开始

难度：Median

### 解题思路

- 本题利用 **二分法** 先找到中间值
- 然后计算比中间值小的数有多少

- 经典策略：从方阵的 **左下角** 开始 **向右向上** 移动寻找比中位数小的个
- 接着和目标值比较差多少该怎么移动，进而找到满足要求的个数

### 代码

```java
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int n = matrix.length;
        // 二分法
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 记录比 mid 小的个数有多少
            int count = LessThanTarget(matrix, mid);
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    private int LessThanTarget(int[][] matrix, int target) {
        int n = matrix.length;
        // i 和 j 定位到矩阵左下角开始查找
        int i = n - 1;
        int j = 0;
        
        int ans = 0;
        while (i >= 0 && j < n) {
            // 如果左下角比目标值小，那整列都小
            if (matrix[i][j] <= target) {
                // 这里是将整列数字个数加入 ans 中
                ans += i + 1;
                // 并且移动到下一列的最后一行
                j++;
            } else {
                // 否则就向上移动一行
                i--;
            }
        }
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/solution/378-you-xu-ju-zhen-zhong-di-kxiao-de-yuan-su-er-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

