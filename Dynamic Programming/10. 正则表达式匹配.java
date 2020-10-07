#### [10. 正则表达式匹配](https://leetcode-cn.com/problems/regular-expression-matching/) + 将 '.'  '*'  'a' 分别讨论

难度：Hard

### 解题思路

- 依据本题匹配规则，需要我们采用动态规划来进行分情况讨论

### 代码

```java
class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null){
            return false;
        }
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        
        for (int i = 1; i < n; i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果匹配，则结果和前一组一样
                if (s.charAt(i) == p.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                // 如果是 '*' 还需要判断其前面的状态
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        // 不匹配就让他变成 empty, 即 a* 变为 empty
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        // 可以变成 1 个字母，或者多个字母，或者 empty, 即 a* 可能变为 a, aa, empty
                        dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/regular-expression-matching/solution/10-zheng-ze-biao-da-shi-pi-pei-jiang-a-fen-bie-tao/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

