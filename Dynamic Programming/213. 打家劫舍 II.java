#### [213. 打家劫舍 II](https://leetcode-cn.com/problems/house-robber-ii/) +  两条路分别进行版本Ⅰ比较

难度：Median

### 解题思路

- 本题是上一 **版本Ⅰ** 的进阶，将房子路线由直线转换成了圆圈
- 那么首位两间房子就不能同时偷，所以我们分为 **两条路线** 遍历：`0 ~ n-2` 和 `1 ~ n - 1`
- 最后将两者得出的结果比较即可选出最大值

### 代码

```java
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 若只有一个房子
        if (nums.length == 1) {
            return nums[0];
        }
        // 若只有两个房子
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        int ans1 = helper(nums, 0, nums.length - 2);
        int ans2 = helper(nums, 1, nums.length - 1);
        // 返回上面两种方式遍历后得到的最大值
        return Math.max(ans1, ans2);
    }
    
    private int helper(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        if (end - start == 1) {
            return Math.max(nums[start], nums[end]);
        }
        // 解法类似于版本Ⅰ
        int[] dp = new int[end - start + 1];
        
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(nums[start + i] + dp[i - 2], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/house-robber-ii/solution/213-da-jia-jie-she-ii-liang-tiao-lu-fen-bie-jin-xi/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

