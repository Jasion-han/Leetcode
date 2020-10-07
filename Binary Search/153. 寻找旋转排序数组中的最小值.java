#### [153. 寻找旋转排序数组中的最小值](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/) + 二分法

难度：Median

### 解题思路

- 通过取中间值先与 **最右边 **元素比较大小
- 若大于右边，则说明在 **右区间 ** 能取到最小值

- 反之在 **左区间** 能取到最小值
- 最后跳出 `while` 循环后只剩 **相邻两元素**，直接比较大小即可。

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
            // 例如：3,4,5,1,2
            // 这里让 mid 与 right 比较进行二分查找最小值
            if (nums[mid] > nums[right]) {
                left = mid;
            // 例如：5,1,2,3,4
            } else if (nums[mid] < nums[right]) {
                right = mid;
            }
        }
        // 最后剩余的相邻两个元素直接比较大小即可
        if (nums[left] < nums[right]) {
            return nums[left];
        } else {
            return nums[right];
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/153-xun-zhao-xuan-zhuan-pai-xu-shu-zu-zhong-de-16/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

