#### [227. 基本计算器 II](https://leetcode-cn.com/problems/basic-calculator-ii/) + 字符串转换更新前后指向

难度：Median

### 解题思路

- 本题相对上一同类型题目简单，少去了括号匹配的麻烦
- 现在只需要挨个通过四种运算符将数字组合起来即可

- 注意前后指针的用法，分别保存当前 **符号前面的结果** 以及当前遍历到的 **数字本身**

### 代码

```java
class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 去除字符串两边以及中间的空格
        s = s.trim().replaceAll(" ", "");
        int n = s.length();
        // 定义之前计算的结果
        int pre = 0;
        // 当前的值
        int ans = 0;
        char sign = '+';
        char[] ch = s.toCharArray();
        
        for (int i = 0; i < n; i ++) {
            int num = 0;
            while (i < n && ch[i] >= '0' && ch[i] <= '9') {
                num = num * 10 + ch[i] - '0';
                i++;
            }
            // ans 加的是该符号前面 pre 曾指向的数字, 接下来 pre 更新指向为该符号后面的数字
            if (sign == '+') {
                ans += pre;
                pre = num;
            } else if (sign == '-') {
                ans += pre;
                pre = -num;
            } else if (sign == '*') {
                pre *= num;
            } else if (sign == '/') {
                pre /= num;
            }
            // 前面四个 if 判断的是哪个符号,这里就跟新为对应的符号
            if (i + 1 < n) {
                sign = ch[i];
            }
        }
        return ans + pre;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/basic-calculator-ii/solution/227-ji-ben-ji-suan-qi-ii-zi-fu-chuan-zhuan-huan-ge/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

