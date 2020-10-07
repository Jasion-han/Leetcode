#### [162. 寻找峰值](https://leetcode-cn.com/problems/find-peak-element/) + 二分法，去重

难度：Median

### 解题思路

- 标准二分法
- 注意比较 **中间** 相邻两元素的峰值大小
- 最后 **剩余两个相邻元素**，直接比较大小即可

### 代码

```java
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 二分法
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            // 比较峰值
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        // 最后比较相邻两个元素大小即可
        if (nums[left] < nums[right]) {
            return right;
        } else {
            return left;
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/find-peak-element/solution/162-xun-zhao-feng-zhi-er-fen-fa-by-jasion_han/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



