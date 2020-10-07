#### [719. 找出第 k 小的距离对](https://leetcode-cn.com/problems/find-k-th-smallest-pair-distance/) + 使用双指针进行二分查找

难度：Hard

### 解题思路

本题采用 **二分查找 + 双指针** 思路解决问题

首先将数组 **排序**，然后使用 **二分查找** 思路将数组进行划分

两元素之间的距离介于 `0` ~ **最大元素和最小元素之差**，那么第 `k` 小的距离必定包含在其中

定义二分查找的 **左边界** `low`，**右边界**  `hight`，**中间值**  `mid`

定义 `cnt` 记录距离小于等于 `mid` 的个数

如果 `cnt < k`，说明第 `k` 个最小距离不会在 `[low, mid]` 之间，需要 **向右扩大范围** 将 `low = mid + 1`

相反则 **向左缩小范围** 使 `hight = mid` (因为第 `k` 个最小距离在 `[l, mid]` 之间)

最后返回 `low` 的值即为第 `k` 小的距离

### 代码

```java
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        // 先将数组排序
        Arrays.sort(nums);
        // 初始二分查找的边界
        int low = 0;
        int hight = nums[n - 1] - nums[0];
        while (low < hight) {
            int mid = (low + hight) / 2;
            // 定义计数器来记录距离，定义左指针 left 作为第一个元素的索引
            int cnt = 0, left = 0;
            // 定义右指针从第一个位置开始向右遍历
            for (int right = 0; right < n; right++) {
                // 两者距离比 mid 大则移动左指针缩小距离
                while (nums[right] - nums[left] > mid) {
                    left++;
                }
                // 记录比 mid 小的距离个数
                cnt += right - left;
            }
            // 如果小于 mid 距离的个数还要比 k 大，则 hight 向左缩小范围
            if (cnt >= k) {
                hight = mid;
            // 否则 low 向右扩大范围
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/find-k-th-smallest-pair-distance/solution/20200326719harder-fen-cha-zhao-shuang-zhi-zhen-by-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

