#### [365. 水壶问题](https://leetcode-cn.com/problems/water-and-jug-problem/) +  gcd求最大公因数法

难度：Median

### 解题思路

本题需要注意几个条件：

- `x` 和 `y` 的最大公因数可以让 `z` 除尽才满足题意，例如 `4`，`2`，`3` 一定不满足

- 这里需要注意 `y` 不能为 `0`，因为它在除数位置
- 然后就是如果 `z` 是 `0`，那么无论如何都为真

- 最后使用 `gcd` 方法求得最大公因数看 `z` 是否能除尽即可。

### 代码

```java
class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z < 0 || x + y < z) {
            return false;
        }
        if (z == 0) {
            return true;
        }
        int gcd = gcd(x, y);
        return z % gcd == 0 ? true : false;
    }
    
    // 求最大公因数,例如 x = 6, y = 4,则 return 2
    private int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return x % y == 0 ? y : gcd(y, x % y);
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/water-and-jug-problem/solution/365-shui-hu-wen-ti-gcdqiu-zui-da-gong-yin-shu-fa-b/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

