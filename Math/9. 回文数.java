#### [9. 回文数](https://leetcode-cn.com/problems/palindrome-number/) + 数学的应用

难度：Easy

### 解题思路

本题为 **基础回文数算法**

一开始要进行合法判断，将不符合回文数的给排除

接下来定义反转变量来保存翻转后的回文数

再保存给定的 `x` 值，用 `num` 来代替进行运算，之后再将一开始给的 `x` 和反转后的值进行比较输出 `true or false`。

### 代码

```java
class Solution {
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        // 若 x 为负数或者个位是 0
        if (x < 0 || x % 10 == 0) {
            return false;
        }

        // 定义反转后的回文数
        int reversed = 0;
        // 事先保存 x 的值，之后只需 num 进行运算
        int num = x;
        while(num != 0){
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        // 拿给定的 X 和反转后的回文数进行比较
        return x == reversed;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/palindrome-number/solution/202003129easy-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

