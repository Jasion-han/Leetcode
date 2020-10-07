#### [35. 搜索插入位置](https://leetcode-cn.com/problems/search-insert-position/) + 标准二分查找法

难度：Easy

### 解题思路

本题使用 **二分查找** 的思想

通过定义中间位置 `mid`，将数组划分为左右两端，每次查找都是一半一半

时间复杂度为 `O(logn)`

### 代码

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 二分法找插入位置
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        // 如果目标值比最小值还要小
        if (target <= nums[left]) {
            return left;
        // 如果目标值介于数组元素之间,但又不相等,则代替相邻右索引并返回
        } else if (nums[left] < target && target <= nums[right]) {
            return right;
        // 如果目标值比最大值还要大
        } else {
            return nums.length;
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/search-insert-position/solution/2020031535easy-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

