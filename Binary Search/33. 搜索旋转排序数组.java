#### [33. 搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/) + 双二分法

难度：Median

### 解题思路

- 本题因为不是常规正序数组，故需要 **分左右 **两部分
- 然后分别在这 **两部分 **使用 **二分法 **寻找目标值

- 最后别忘了考虑 **边界值 ** 的情况

### 代码

```java
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 二分法
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            // 坐标轴左上部分，即旋转后的前一部分
            if (nums[mid] >= nums[left]) {
                // 在该区间内再进行二分法
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            // 坐标轴右下部分，即旋转后的后一部分
            } else {
                // 在该区间内再进行二分法
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        // 考虑边界值
        if (nums[left] == target) {
            return left;
        } else if (nums[right] == target) {
            return right;
        } else {
            return -1;
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/33-sou-suo-xuan-zhuan-pai-xu-shu-zu-shuang-er-fen-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

