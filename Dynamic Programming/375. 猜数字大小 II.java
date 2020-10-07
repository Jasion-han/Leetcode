#### [375. 猜数字大小 II](https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii/) + 在确保能赢的情况下再求最小开销

难度：Median

### 解题思路

仔细揣摩！

- 举个例子：你要买一杯 10元奶茶，目前手里有三张抵扣券，分别为 5元，10元，15元
- 所有抵扣券中若能用则最小开销是 `5` 元
- 如果要抵扣一杯奶茶需要的最小开销则是 `10` 元

- 即我们需要在确保能抵扣掉一杯奶茶价钱的情况下再追求最小的开销

### 代码

```java
class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        
        for (int i = n - 1; i > 0; i--) {
            for (int j = i + 1; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                // 从 i ~ j 寻找最小的开销
                for (int x = i; x < j; x++) {
                    // 后半部分表示当花了 x 之后可以在 i ~ x - 1 或者 x + 1 ~ j 的开销内找最大开销确保能对
                    dp[i][j] = Math.min(dp[i][j], x + Math.max(dp[i][x - 1], dp[x + 1][j]));
                }
            }
        }
        // 返回从 1 ~ n 猜中某个数字的最小命中的开销(不是最小开销，是确保能赢的最小开销)
        return dp[1][n];
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii/solution/375-cai-shu-zi-da-xiao-ii-zai-que-bao-neng-ying-de/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

