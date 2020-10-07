#### [312. 戳气球](https://leetcode-cn.com/problems/burst-balloons/) + 不同间隔下寻找每组气球的最大值

难度：Hard

### 解题思路

- 将 **不同间隔下** 的每组气球分布情况进行比较取出最大值
- 这样最后的结果就是所有气球的最大值

### 代码

```java
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int len = n + 2;
        int[] tmp = new int[len];
        // 制造新的数组增加存放左右边界值 1
        for (int i = 0; i < n; i++) {
            tmp[i + 1] = nums[i];
        }
        tmp[0] = 1;
        tmp[len - 1] = 1;
        // 对新的数组长度进行 dp 遍历
        int[][] dp = new int[len][len];
        
        
        // 这里遍历每组元素之间的间隔，从 2 开始递增(即戳破一个气球后认为间隔还在)
        for (int gap = 2; gap < len; gap++) {
            // 遍历以该间隔组成的一组气球
            for (int left = 0; left < len - gap; left++) {
                int cur = 0;
                int right = left + gap;
                // 定义 i 在 左右区间内移动进行比较取最大值
                for (int i = left + 1; i < right; i++) {
                    cur = Math.max(cur, dp[left][i] + dp[i][right] + tmp[left] * tmp[i] * tmp[right]);
                }
                // 更新该组气球下的最大值
                dp[left][right] = cur;
            }
        }
        // 最后返回整个区间内的最大值
        return dp[0][len - 1];
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/burst-balloons/solution/312-chuo-qi-qiu-bu-tong-jian-ge-xia-xun-zhao-mei-z/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

