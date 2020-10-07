#### [260. 只出现一次的数字 III](https://leetcode-cn.com/problems/single-number-iii/) + 异或，与，取反的使用

难度：Median

### 解题思路

- 本题首先将数组中所有的数都 **异或一遍**，此时的结果就是两目标数字 **异或的结果**
- 然后通过 `x = x & (~(x - 1));` 制造分离因子 `x`

- 最后再让分离因子 `x` 分别和数组中所有元素进行 **按位与** 并让结果为 `0` 的分一组，不为 `0` 的分一组
- 因为偶数个的数字异或后就变成了 `0` ，那么就只剩下目标数字

- 故经过分组后就可以筛选出来两个目标数字了。

### 代码

```java
class Solution {
    public int[] singleNumber(int[] nums) {
        int[] ans = new int[2];
        int x = 0;
        // 将所有数字异或后,此时 x 的值就是两个目标数字异或的值
        for (int num : nums) {
            x ^= num;
        }
        // 以 [1,2,1,3,2,5] 为例
        // 此时 x 为 110 & 010 = 010 也就是 2
        x = x & (~(x - 1));
        
        for (int num : nums) {
            // 1 和 5 & x 都等于 0
            if ((num & x) == 0) {
                // 经过两个 1 和 1 个 5 异或后就只分离出来 5 并放进 ans[0]
                ans[0] ^= num;
            // 2 和 3 & x 都不等与 0
            } else {
                // 经过两个 2 和 1 个 3 异或后就只分离出来 3 并放进 ans[1]
                ans[1] ^= num;
            }
        }
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/single-number-iii/solution/260-zhi-chu-xian-yi-ci-de-shu-zi-iii-yi-huo-yu-qu-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

