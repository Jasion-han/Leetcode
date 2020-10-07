#### [137. 只出现一次的数字 II](https://leetcode-cn.com/problems/single-number-ii/) + 异或运算和按位与的结合

难度：Median

### 解题思路

我们知道，对于任意二进制位 xx ,有以下特点：

异或运算：`x ^ 0 = x ， x ^ 1 = ~x` 

与运算：`x & 0 = 0 ， x & 1 = x`

- 演变流程如下：

  ```
  if two == 0:
    if n == 0:
      one = one
    if n == 1:
      one = ~one
  if two == 1:
      one = 0
  ```

  

- 引入 **异或运算** ，可将以上拆分简化为

  ```
  if two == 0:
      one = one ^ n
  if two == 1:
      one = 0
  ```

  

- 引入 **与运算** ，可继续简化为：

  ```
  one = one ^ n & ~two 
  ```

  

### 代码

```java
class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/single-number-ii/solution/137-zhi-chu-xian-yi-ci-de-shu-zi-ii-yi-huo-yun-sua/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

