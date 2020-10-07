#### [91. 解码方法](https://leetcode-cn.com/problems/decode-ways/) + 包括或不包括自己

难度：Median

### 解题思路

- 本题因为要考虑之前两位置的计算情况
- 故现在将自己与前者 **看作整体** 计算和 **单独计算** 分别讨论再相加即可

### 代码

解法一：

```java
class Solution {
    // space : O(n)
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        
        int[] dp = new int[s.length() + 1];
        // 因为要考虑前两位，所以首先把最开始两个位置进行初始化
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 1; i < s.length(); i++) {
            // 如果不为 0 就让 i + 1 加上 i 所计算的总数
            if (s.charAt(i) != '0') {
                dp[i + 1] += dp[i];
            }
            // 让 i 和 i + 1 为整体加上 i - 1 时所计算的总数
            int num = Integer.valueOf(s.substring(i - 1, i + 1));
            if (num >= 10 && num <= 26) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}
```



解法二：

```java
class Solution {
    //space : O(1)
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int c1 = 1;
        int c2 = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                c1 = 0;
            }
            if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) <= '6') {
                c1 = c1 + c2;
                c2 = c1 - c2;
            } else {
                c2 = c1;
            }
        }
        return c1;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/decode-ways/solution/91-jie-ma-fang-fa-bao-gua-huo-bu-bao-gua-zi-ji-by-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

