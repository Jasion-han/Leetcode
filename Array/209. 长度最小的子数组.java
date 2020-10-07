#### [209. 长度最小的子数组](https://leetcode-cn.com/problems/minimum-size-subarray-sum/) + 典型滑动窗口问题

难度：Median

### 解题思路

本题使用了 **窗口滑动** 的思想

窗口一开始从 **右边** 开始滑动，将每次访问到的数字加进 `sum`里

如果 `sum` 现在的值比 `s` 大，先记录当前的子数组长度，然后移动 **左边** 窗口继续遍历

最后遍历完一遍数组后，返回 `min` 看是否改变，更新过后的值即为所求子数组长度

### 代码

```java
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
       
        // 记录当前已访问的数字之和
        int sum = 0;
        // 初始化 min 为最大值
        int min = n + 1;

        int left = 0;
        int right = 0;
        while (right < n) {
            // 右窗口开始滑动
            sum += nums[right];
            right++;
            while (sum >= s) {
                // 记录当前满足要求的子数组长度
                min = Math.min(min, right - left);
                // 左窗口开始滑动
                sum -= nums[left];
                left++;
            }
        }
        // 判断 min 有没有被改变
        return min == n + 1 ? 0 : min;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum/solution/20200321209median-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



