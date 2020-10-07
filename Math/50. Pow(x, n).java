#### [50. Pow(x, n)](https://leetcode-cn.com/problems/powx-n/) + 二分双解法

难度：Median

### 解题思路

两个解都是考虑到了整数溢出的情况，一种是在 `int` 基础上求解，另一种转换成 `long` 类型求解

### 代码

解法一：

```java
class Solution {
    public double myPow(double x, int n) {
        boolean isNegative = false;
        // 以 2 ^ (-4) 为例子
        if (n < 0) {
            isNegative = true;
            // 这里如果 n 是负无穷，那么直接 n = -n 会越界
            n = -(n + 1);
            x = 1 / x;
        }
        
        double ans = 1;
        double tmp = x;
        // 到这里变成了求解 (1 / 2) ^ 3
        while (n != 0) {
            if (n % 2 == 1) {
                ans *= tmp;
            }
            tmp *= tmp;
            n /= 2;
        }
        // 因为少乘一次，所以要再乘一下 x
        if (isNegative) {
            ans *= x;
        }
        return ans;
    }
}
```

解法二：

```java
class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        // 如果 n 是负无穷那么取反后会发生越界,故用 long 类型存储
        long N = n;
        if (n < 0) {
            N = -N;
            x = 1 / x;
        }
        double pro = x;
        for (long i = N; i > 0; i /= 2) {
            if (i % 2 == 1) {
                ans *= pro;
            }
            pro *= pro;
        }
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/powx-n/solution/50-powx-n-er-fen-shuang-jie-fa-by-jasion_han/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

