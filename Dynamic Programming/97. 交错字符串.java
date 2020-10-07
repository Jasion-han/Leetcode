#### [97. 交错字符串](https://leetcode-cn.com/problems/interleaving-string/) + boolean判断s1和s2是否和s3一一对应

难度：Hard

### 解题思路

- 目标路径中每个字符都是从 `s1`（向下）或者 `s2`（向右）拿到的，所以只要判断是否存在这条路径即可
- 状态初始化：`dp[0][0] = true`，表示两个空字符串能够组成一个空字符串。
- 对于 `dp[i][j]` 该状态来说，要想组成 `s3[0, i + j)`，其最后一个字符 `s3[i + j - 1]` 要么来自 `s1[i - 1]`,  要么来自 `s2[j - 1]`

### 代码

```java
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (s3.length() != m + n) {
            return false;
        }
        // 动态规划，dp[i, j]表示 s1 前 i 字符能与 s2 前 j 字符组成 s3 前 i + j 个字符；
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        
        for (int i = 1; i <= m ; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int j = 1; j <= n ; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1))
                    || (dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1));
            }
        }
        return dp[m][n];
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/interleaving-string/solution/97-jiao-cuo-zi-fu-chuan-booleanpan-duan-s1he-s2shi/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

