#### [70. 爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/) + dp 从第二个楼梯开始有规律

难度：Easy

### 解题思路

- 本题很好的使用 `dp` 解决问题，很经典的一道题目！

### 代码

```java
class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        // 从第二个楼梯开始就可以利用前两次的关系
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/climbing-stairs/solution/70-pa-lou-ti-dp-cong-di-er-ge-lou-ti-kai-shi-you-g/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

