#### [8. 字符串转换整数 (atoi)](https://leetcode-cn.com/problems/string-to-integer-atoi/) + 多情况讨论

难度：Median

### 解题思路

本题和上一题有相似之处，难就难在讨论的情况比较多

情况分为：
从左遍历字符串，可以遇到空格，直到遇到  `+` 或者数字或者 `-` 就表示要转换的数字开始，如果之后遇到除了数字的其他字符（包括空格）就结束遍历，输出结果，不管后边有没有数字了，例如 " - 32332ada2323" 就输出 "- 32332"。

如果遇到空格或者 `+` 或者数字或者 `-` 之前遇到了其他字符，就直接输出 `0` ，例如 "we1332"。

时间复杂度：O(n)，`n` 是字符串的长度。

空间复杂度：O(1)。

### 代码

解法一：

```java
class Solution {
    public int myAtoi(String str) {
        char[] temp = str.toCharArray();
        int n = temp.length;
        int index = 0;
        
        // 开头是空格就继续，移动到最后还没有数字则返回 0
        while (index < n && temp[index] == ' ') {
            index++;
        }
        if (index == n) {
            return 0;
        }
        
        // 定义负数，开始为假
        boolean negative = false;
        if (temp[index] == '-') {
            // 若有负号，则标记为真
            negative = true;
            index++;
        } else if (temp[index] == '+') {
            index++;
        } else if (!Character.isDigit(temp[index])) {
            return 0;
        }
        
        // 排除了错误因素后
        int ans = 0;
        while (index < n && Character.isDigit(temp[index])) {
            // 对 ‘0’ 做差求得具体数字
            int digit = temp[index] - '0';
            
            // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
            // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
            if ((Integer.MAX_VALUE - digit) / 10 < ans) {
                // 越界情况下如果是负数就是最小值，否则最大值
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            // 非越界情况下正常计算
            ans = ans * 10 + digit;
            index++;
        }
        // 正常情况下判断是负数还是正数
        return negative ? -ans : ans;
    }
}
```

解法二：

```java
class Solution {
    public int myAtoi(String str) {
        
        // 去除左右两边的空格(这步要在判空前面)
        str = str.trim();
        
        if (str == null ||str.length() == 0) {
            return 0;
        }
        
        // 正负号
        int sign = 1;
        int idx = 0;
        char c = str.charAt(0);
        if (c == '+') {
            sign = 1;
            idx++;
        } else if (c == '-') {
            sign = -1;
            idx++;
        }
        
        // 防止越界，使用 long 来定义
        long sum = 0;
        for (int i = idx; i < str.length(); i++) {
            // 遇到非数字元素，则返回之前遍历过的内容即可
            if (!Character.isDigit(str.charAt(i))) {
                return (int)sum * sign;
            }
            sum = sum * 10 + str.charAt(i) - '0';
            if (sign == 1 && sum > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && (-1) * sum < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int)sum * sign;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/string-to-integer-atoi/solution/202003118median-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



