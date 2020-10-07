#### [377. 组合总和 Ⅳ](https://leetcode-cn.com/problems/combination-sum-iv/) + dp

难度：Median

### 解题思路

- 本题的 **状态转移方程** 如下

- dp[i] = dp[i - nums[0]] + dp[i - nums[1]] + ... + dp[i - nums[len - 1]]

- 例如：`nums = {1, 2, 3}; target = 4`

- dp[4] = dp[4 - 1] + dp[4 - 2] + dp[4 - 3] = dp[3] + dp[2] + dp[1]

```
dp[1] = dp[0] = 1;
dp[2] = dp[1] + dp[0] = 2;
dp[3] = dp[2] + dp[1] + dp[0] = 4;
dp[4] = dp[4 - 1] + dp[4 - 2] + dp[4 - 3] = dp[3] + dp[2] + dp[1] = 7
```

### 代码

```java
class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        
        int[] dp = new int[target + 1];
        // dp[0] 表示组成 0，一个数都不选就可以了，所以 dp[0] = 1
        // 在 0 这一点，我们定义 dp[0] = 1，它表示如果 nums 里有一个数恰好等于 target，它单独成为 1 种可能。
        dp[0] = 1;
        // 使用 dp 数组，dp[i] 代表组合数为 i 时使用 nums 中的数能组成的组合数的个数
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }

        }
        return dp[target];
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/combination-sum-iv/solution/377-zu-he-zong-he-iv-dp-by-jasion_han/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

