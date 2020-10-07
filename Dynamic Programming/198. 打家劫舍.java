#### [198. 打家劫舍](https://leetcode-cn.com/problems/house-robber/) + 经典 dp 问题，考虑三种情况

难度：Easy

### 解题思路

- 经典问题，具体看代码，之后还会有更多进阶版本。

### 代码

```java
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        
        // 如果只有一个房子
        dp[0] = nums[0];
        if (nums.length == 1) {
            return dp[0];
        }
        
        // 如果只有两个房子,就在这两个房子之间选出最大者
        dp[1] = Math.max(nums[0], nums[1]);
        if (nums.length == 2) {
            return dp[1];
        }
        
        // 如果有超过 2 个房子
        for (int i = 2; i < nums.length; i++) {
            // 就判断当前房子的值加上偷上上个房子之后的总值和偷上个房子的总值哪个更大
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/house-robber/solution/198-da-jia-jie-she-jing-dian-dp-wen-ti-kao-lu-san-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

