#### [7. 整数反转](https://leetcode-cn.com/problems/reverse-integer/) + 数学法

难度：Easy

### 解题思路

本题使用 **数学思维** 判断，为了有效防止溢出问题

依次用 `last` 取出当前数字的最后一位，并累加。

关键在于如何判断整数溢出：将每次操作后的数字用临时变量 `temp` 存储，若与操作前的结果不等，则发生溢出，直接返回 `0`

### 代码

解法一：

```java
class Solution {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int last = x % 10;
            int temp = ans * 10 + last;
            // 判断是否溢出，若是则直接返回0
            if ((temp - last) / 10 != ans) {
                return 0;
            }
            ans = temp;
            x /= 10;
        }
        return ans;
    }
}
```

解法二：

```java
class Solution {
    public int reverse(int x) {
        long sum = 0;
        while (x != 0) {
            sum = sum * 10 + x % 10;
            x /= 10;
        }
        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)sum;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/reverse-integer/solution/202003117easy-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



