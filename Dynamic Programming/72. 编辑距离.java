#### [72. 编辑距离](https://leetcode-cn.com/problems/edit-distance/) + 三方面比较较小者

难度：Hard

### 解题思路

- 基本套路 **初始化** 动态方程，横纵边界值，最后全局遍历
- 这里需要注意是三方面比较：**横着一路**，**竖着一路**，还有其**本身**，选出最小者再 `+ 1` 即为当前最小值。

### 代码

```java
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        // 初始化，注意边界
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        
        // 注意边界，与上面边界情况跟前不跟后，跟后不跟前
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果前后两位置字母一样就直接复制过去即可
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                // 如果不一样就比较较小者，别忘了 + 1
                } else {
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i][j])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/edit-distance/solution/72-bian-ji-ju-chi-san-fang-mian-bi-jiao-jiao-xiao-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

