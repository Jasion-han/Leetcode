#### [201. 数字范围按位与](https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/) + 位运算 - 右移

难度：Median

### 解题思路

- 本题采用位运算之右移可以很巧妙的解决问题
- 在给定的数字区间内将两端点元素分别采用 **右移运算** 直到相等，同时记录 **移动次数 power**
- 因为题目要求 **返回该区间内所有数字的按位与**，所以该右移运算停止的时候就是不受影响的位置，而之前移动的位置都会被区间内某个元素 "与" 成 `0`

- 最后只需使 **当前停下来的元素值** 再 **左移** 回去相应的次数 `power` 即为该区间内所有元素经过按位与后的最终结果

### 代码

```java
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int power = 0;
        // 以 [5, 7] 为例
        // m: 101 010 001  
        // n: 111 011 001
        // p:  0   1   2
        while (m != n) {
            m >>= 1;
            n >>= 1;
            power++;
        }
        return m << power;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/solution/201-shu-zi-fan-wei-an-wei-yu-wei-yun-suan-you-yi-b/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

