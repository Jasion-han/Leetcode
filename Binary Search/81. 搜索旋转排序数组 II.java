#### [81. 搜索旋转排序数组 II](https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/) +  二分法，去重

难度：Median

### 解题思路

- 此题是 `33` 题的变形，将原有数组增加了 **重复元素**
- 那么我们在进行与 `33` 题相同操作前需要 **先对数组元素去重**

- 剩下的二分查找过程和 `33` 题一样

- 最后考虑边界情况的时候只需看 **是否找到** 即可，不用查找具体元素

### 代码

```java
class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        // 二分法
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            // 若中间元素就命中，返回 true 即可
            if (nums[mid] == target) {
                return true;
            }
            
            // 排除重复元素
            if (nums[mid] == nums[right]) {
                right--;
            } else if (nums[mid] == nums[left]) {
                left++;
            // 该步骤同 33 题
            } else if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else if (nums[mid] < nums[right]) {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        // 考虑边界情况
        if (nums[left] == target || nums[right] == target) {
            return true;
        } else {
            return false;
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/solution/81-sou-suo-xuan-zhuan-pai-xu-shu-zu-ii-er-fen-fa-q/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

