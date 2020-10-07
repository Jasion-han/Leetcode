#### [154. 寻找旋转排序数组中的最小值 II](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/) + 二分法，去重

难度：Hard

### 解题思路

本题是上一题 `153` 的变形，主要加上了 **重复** 元素，所以我们需要 **去重**，剩下的步骤基本一致

### 代码

```java
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 二分法
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            // 如果和右边的值一样，需要右指针左移
            } else {
                right--;
            }
        }
        // 最后选出相邻两元素最小者即可
        if (nums[left] < nums[right]) {
            return nums[left];
        } else {
            return nums[right];
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/solution/154-xun-zhao-xuan-zhuan-pai-xu-shu-zu-zhong-de--12/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

