#### [1071. 字符串的最大公因子](https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/) + 巧用 gcd 函数求解最大公因子

难度：Easy

### 解题思路

本题考查字符串的 **最大公因子**

字符串 `A` 和 `B` 拼接起来和反向拼接一样则满足 `S = T + T + T + ...`

这里使用 `gcd` 函数，巧妙将公因子筛选出来

传入两个字符串的长度 `a` 和 `b`，依次将短的长度 `b` 和 `0` 比较，若不为 `0`，则将长度 `a` 除以 `b` 直到整除，即达到最大公因子的寻找

### 代码

```java
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        
        if(!(str1 + str2).equals(str2 + str1)){//字符串相反拼接是否一致
            return "";
        }        
        return str1.substring(0, gcd(n1, n2));//输出最大公因子
    }
    
    private int gcd(int a, int b){//gcd函数
        return b == 0 ? a : gcd(b, a % b);//很妙的算法
    }    
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/solution/20200312mei-ri-yi-ti-easy-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



