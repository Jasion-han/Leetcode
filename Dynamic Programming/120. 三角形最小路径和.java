#### [120. 三角形最小路径和](https://leetcode-cn.com/problems/triangle/) + 由下往上存储不断更新的值

难度：Median

### 解题思路

- 本题采用 **由下往上** 的遍历顺序不断对每行各个元素的值进行更新
- 更新条件就是将其下面一层中 **较小的值** 加到当前层来，以此类推直到最顶端

- 那么最顶端也就是 `dp[0]` 存放的就是最小的路径和。

### 代码

```java
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        // 计算三角形的行数
        int rows = triangle.size();
        int[] dp = new int[rows + 1];
        
        // 从最后一行开始往上遍历
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                // 每个位置存放的是其下面一层相邻节点的较小者和他自己的和
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        // 最后三角形的顶端的位置即 dp[0] 存放的就是最小的路径总和
        return dp[0];
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/triangle/solution/120-san-jiao-xing-zui-xiao-lu-jing-he-you-xia-wang/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

