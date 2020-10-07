#### [53. 最大子序和](https://leetcode-cn.com/problems/maximum-subarray/) + 以子序列的结束点为基准

难度：Easy

### 解题思路

本题使用 **动态规划** 解决问题

遍历数组，若之前遍历过的元素之和 `sum` 为正数，就可以加上当前的元素 `num`，否则就更新 `sum` 指向当前的 `num`

最终得到的结果 `ans` 再和 `sum` 比较取最大值即可。

### 代码

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {//如果有增益，就加上当前的num
                sum += num;
            } else {//如果sum不是正数，就更新sum指向当前num
                sum = num;
            }
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/maximum-subarray/solution/2020031553easy-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



