#### [29. 两数相除](https://leetcode-cn.com/problems/divide-two-integers/) +  long型，左移

难度：Median

### 解题思路

- 这里用到 **异或** 来取符号位
- 随后需要先转换成 `long` 存储以防越界

- 然后取绝对值以 **正数 **的形式进行 **位移 **操作
- 最后将符号位添到其中即可。

### 代码

```java
class Solution {
    public int divide(int dividend, int divisor) {
        // 依据异或相同为 0 不同为 1 的概念
        // 相同为 0 的话其结果是假则取到的是 1，如果不同为 1 其结果是真则取到的是 -1
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        
        long ans = 0;
        
        // 19 / 3 -> 3 * 2 ^ 2 + 3 * 2 ^ 1 = 3 * (2 ^ 2 + 2 ^ 1)
        // 要求的就是上面括号里面的内容，这里用 mul 存储
        // 用 tmp 存储 ldivisor 不断左移(乘 2)的结果
        while (ldivisor <= ldividend) {
            long tmp = ldivisor;
            long mul = 1;
            // 左移 1 位代表乘 2
            while (ldividend >= (tmp << 1)) {
                tmp <<= 1;
                mul <<= 1;
            }
            ans += mul;
            ldividend -= tmp;
        }
        // 加上符号位
        ans *= sign;
        
        if (ans >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int)ans;
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/divide-two-integers/solution/29-liang-shu-xiang-chu-longxing-zuo-yi-by-jasion_h/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

