#### [367. 有效的完全平方数](https://leetcode-cn.com/problems/valid-perfect-square/) + 二分法

难度: Easy

### 解题思路

- 题目已给出 **正整数**，所以不用判断负数和零的情况
- 然后通过 **二分法** 进行搜索

- 最后类似于 `4` 这样的数字，需要单独处理一下

### 代码

```java
class Solution {
    public boolean isPerfectSquare(int num) {
        // 因为 num 是正整数,所以小于 2 为真
        if (num < 2) {
            return true;
        }
        long left = 2;
        // 这里不用到 num,一半就够用
        long right = num / 2;
        while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            long mul = mid * mid;
            if (mul == num) {
                return true;
            } else if (mul > num) {
                right = mid;
            } else {
                left = mid;
            }
        }
        // 这里考虑 num 类似于 4 的情况
        if (left * left == num || right * right == num) {
            return true;
        }
        return false;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/valid-perfect-square/solution/367-you-xiao-de-wan-quan-ping-fang-shu-er-fen-fa-b/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

