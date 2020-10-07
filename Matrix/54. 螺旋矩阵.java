#### [54. 螺旋矩阵](https://leetcode-cn.com/problems/spiral-matrix/) + 顺时针删除每一行每一列

难度：Median

### 解题思路

**上右下左** 依次遍历，每遍历一行或一列就 “删除”，遍历到的元素放入 `ans` 最后返回即可

### 代码

```java
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0) {
            return ans;
        }
        // 定义第一行，最后一行，第一列，最后一列
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int cowBegin = 0;
        int cowEnd = matrix[0].length - 1;
        
        while (rowBegin <= rowEnd && cowBegin <= cowEnd) {
            // →
            for (int j = cowBegin; j <= cowEnd; j++) {
                ans.add(matrix[rowBegin][j]);
            }
            // 向下移动一行(删除第一行)
            rowBegin++;
            
            // ↓
            for (int j = rowBegin; j <= rowEnd; j++) {
                ans.add(matrix[j][cowEnd]);
            }
            // 向左移动一列(删除最后一列)
            cowEnd--;
            
            // ←
            if (rowBegin <= rowEnd) {
                for (int j = cowEnd; j >= cowBegin; j--) {
                    ans.add(matrix[rowEnd][j]);
                }
            }
            // 向上移动一行(删除最后一行)
            rowEnd--;
            
            // ↑
            if (cowBegin <= cowEnd) {
                for (int j = rowEnd; j >= rowBegin; j--) {
                    ans.add(matrix[j][cowBegin]);
                }
            }
            // 向右移动一列(删除第一列)
            cowBegin++;
        }
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/spiral-matrix/solution/54-luo-xuan-ju-zhen-shun-shi-zhen-shan-chu-mei-yi-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

