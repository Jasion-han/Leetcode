#### [371. 两整数之和](https://leetcode-cn.com/problems/sum-of-two-integers/) + 位运算 - 与，异或，左移

难度：Easy

### 解题思路

- 本题使用三种位运算求解两数之和，没有了加减号真的难上一层楼！
- 两个数相加，第一步用 **与**，第二步用 **异或**，第三步将 "与" 出来的值 **左移** 一位

- 就这样直到左移成 `0` 后停止 `while` 循环，最后 **异或的结果** 就是最终求和结果。

### 代码

```java
class Solution {
    public int getSum(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        // 例如 5, 6, 和为 11
        //   101
        //   110
        //  1011
        while (b != 0) {
            // 100  1000
            int carry = a & b;
            // 011  1011
            a = a ^ b;
            // 1000 0000
            b = carry << 1;
        }
        return a;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/sum-of-two-integers/solution/371-liang-zheng-shu-zhi-he-wei-yun-suan-yu-yi-huo-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

