#### [115. 不同的子序列](https://leetcode-cn.com/problems/distinct-subsequences/) + dp法

难度：Hard

### 解题思路

列出动态方程，使用动态规划求解即可

### 代码

```java
class Solution {
    public int numDistinct(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int[][] dp = new int[tLen + 1][sLen + 1];
        
        for (int j = 0; j <= sLen; j++) {
            dp[0][j] = 1;
        }
        
        for (int i = 1; i <= tLen; i++) {
            for (int j = 1; j <= sLen; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[tLen][sLen];
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/distinct-subsequences/solution/115-bu-tong-de-zi-xu-lie-dp-by-jasion_han/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

