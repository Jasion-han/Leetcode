#### [4. 寻找两个正序数组的中位数](https://leetcode-cn.com/problems/median-of-two-sorted-arrays/) +二分查找寻找中位数

难度：Hard

### 解题思路

感谢weiwei哥帮助（官方第一条留言）

### 代码

```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 选择短数组作为操作组
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        
        // 两数组分割线左边之和
        int totalLeft = (m + n + 1) / 2;
        
        // 初始定义最后求平均数时的左右边界值
        int left = 0;
        int right = m;
        
        while (left < right) {
            // i 指向短数组中间
            int i = left + (right - left + 1) / 2;
            // j 指向长数组中间
            int j = totalLeft - i;
            
            if (nums1[i - 1] > nums2[j]) {
                // 下一轮搜索的区间 [left, i - 1]
                right = i - 1;
            } else {
                // 下一轮搜索的区间 [i, right]
                left = i;
            }
        }
        
        int i = left;
        int j = totalLeft - i;
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];
        
        if (((m + n) % 2) == 1) {
            // 如果是奇数个，选出分割线左边的最大值
            return Math.max(nums1LeftMax, nums2LeftMax);
        } else {
            // 如果是偶数个，选出分割线左边最大值和右边最小值求平均数
            return (double) (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2;
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/202003064hard-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

