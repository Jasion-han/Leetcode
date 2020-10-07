#### [34. 在排序数组中查找元素的第一个和最后一个位置](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/) + 二分法

难度：Median

### 解题思路

- 本题是要找两个位置，所以应该用 **两个二分搜索** 分别找第一个和最后一个位置
- 当用二分找 **第一个位置**的时候，尽可能的遍历 `mid` **左边** 元素，

- 找 **第二个位置** 的时候，尽可能遍历 `mid` **右边** 元素
- 这样找到的两个元素的索引放入 `ans` 数组中即可。

### 代码

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        if (nums == null || nums.length == 0) {
            return ans;
        }
        // 寻找左右索引
        int left = findLeft(nums, target);
        int right = findRight(nums, target);
        // 将索引放入 ans 数组中
        ans[0] = left;
        ans[1] = right;
        return ans;
    }
    
    // 二分法寻找最左边元素索引
    private int findLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            // 先判断目标元素是否在 mid 或者 mid 左边
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        // 因为找最左边所以先判断左边元素
        if (nums[left] == target) {
            return left;
        } else if (nums[right] == target) {
            return right;
        } else {
            return -1;
        }
    }
    
    // 二分法寻找最右边元素索引
    private int findRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            // 先判断目标元素是否在 mid 或者 mid 右边
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        // 因为找最右边所以先判断右边元素
        if (nums[right] == target) {
            return right;
        } else if (nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/34-zai-pai-xu-shu-zu-zhong-cha-zhao-yuan-su-de--21/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

