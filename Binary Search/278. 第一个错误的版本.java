#### [278. 第一个错误的版本](https://leetcode-cn.com/problems/first-bad-version/) + 二分法

难度：Easy

### 解题思路

简单的二分法题目

### 代码

```java
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
         
        // 二分法设置一头一尾双指针
        int left = 1;
        int right = n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            // 如果 mid 不是错误版本，就遍历 mid 右边的元素
            if (isBadVersion(mid) == false) {
                left = mid;
            } else {
                right = mid;
            }
        }
        // 如果一开始第一个就是错误的版本，直接返回第一个即可
        if (isBadVersion(left) == true) {
            return left;
        }
        return right;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/first-bad-version/solution/278-di-yi-ge-cuo-wu-de-ban-ben-er-fen-fa-by-jasion/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

