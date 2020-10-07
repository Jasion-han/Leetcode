#### [69. x 的平方根](https://leetcode-cn.com/problems/sqrtx/) + 二分法

难度：Easy

### 解题思路

- 使用**二分法**查找中间位置判断是否为其平方根
- 对于像 `7` 这样的数字，应该**额外进行判断**才能得出结果

### 代码

```java
class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        
        int left = 0;
        int right = x;
        // 标准二分模板
        while (left  + 1 < right) {
            int mid = left + (right - left) / 2;
            // 这里这样写是为了防止溢出，如果写成 mid * mid == x 则需要用 long 类型存储
            if (mid == x / mid) {
                return mid;
            } else if (mid > x / mid) {
                right = mid;
            } else {
                left = mid;
            }
        }
        // 像 7 这种情况需要额外考虑一下
        if (right > x / right) {
            return left;
        }
        return right;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/sqrtx/solution/69-x-de-ping-fang-gen-er-fen-fa-by-jasion_han/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

