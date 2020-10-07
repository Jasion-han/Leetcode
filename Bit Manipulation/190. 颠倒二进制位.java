#### [190. 颠倒二进制位](https://leetcode-cn.com/problems/reverse-bits/) + 采用哨兵 1 进行头尾相匹配

难度：Easy

### 解题思路

- 初始新的二进制结果 `ans` 为 `0`
- 当进入 `for` 循环内率先左移一位则变成了 `1 0`

- 而此时最左边的 `1` 并没有真正的和原二进制一一匹配，只是作为哨兵一样的存在

- 当遍历完整个二进制后，该哨兵也会随着 `ans` 不断左移出去，新的最左边的值则是真正匹配过后的值。

### 代码

```java
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        if (n == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            // 初始结果一开始为 1 0,实际对应位置是从 0 开始,1 相当于哨兵
            ans <<= 1;
            // 从末尾开始逐个判断原二进制数中该位置是否为 1
            if ((n & 1) == 1) {
                // 如果是 1 就将初始结果中的 0 改为 1
                ans += 1;
            }
            // 原二进制右移一位,即往前继续扫描
            n >>= 1;
        }
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/reverse-bits/solution/190-dian-dao-er-jin-zhi-wei-cai-yong-shao-bing-1-j/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

