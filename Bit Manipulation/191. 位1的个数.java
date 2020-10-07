#### [191. 位1的个数](https://leetcode-cn.com/problems/number-of-1-bits/) + 按位与，只扫描有1的位置

难度：Easy

### 解题思路

- 本题可以通过按位与的方法对该二进制 **从后往前** 扫描出现 `1` 的位置

- 通过多次 **按位与** 使得二进制变为 `0`，那么原来二进制中 `1` 的个数就是按位与到 `0` 的次数

  例如：`n = 10010`, 那么 `n - 1 = 10001` 按位与之后变成 `10000`，`ans++`

  此时 `n = 10000`, 那么 `n - 1 = 01111` 按位与之后变成 `00000`，`ans++`

  最终 `ans = 2`，也就是原二进制中 `1` 的个数为 `2`

### 代码

```java
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            // 每次从后往前消 1,同时计数 + 1
            n &= (n - 1);
            ans++;
        }
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/number-of-1-bits/solution/191-wei-1de-ge-shu-an-wei-yu-zhi-sao-miao-you-1de-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

