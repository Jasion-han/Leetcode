#### [224. 基本计算器](https://leetcode-cn.com/problems/basic-calculator/) + 栈的使用，递归调用自己

难度：Hard

### 解题思路

- 本题两种思路
- 可以用 **栈** 来依次的解决不同情况下的问题
- 还可以用简单 **递归** 将大问题拆成子问题解决

### 代码

解法一：

```java
class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        // 定义符号的正负和结果
        int sign = 1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 如果是数字
            if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                // 如果相连的也是数字
                while (i + 1 < n && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                // 更新结果
                ans += num * sign;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(ans);
                stack.push(sign);
                ans = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                // 第一个 pop 出来的是符号位，第二个是进入括号前的结果
                ans = ans * stack.pop() + stack.pop();
            } 
        }
        return ans;
    }
}
```



解法二：

```java
class Solution {
    
    int idx = 0;
    public int calculate(String s) {
        // 去除数字之间的空格
        s = s.replaceAll(" ", "");
        int ans = helper(s);
        return ans;
    }
    
    private int helper(String s) {
        if (idx >= s.length()) {
            return 0;
        }
        
        int ans = 0;
        char sign = '+';
        while (idx < s.length()) {
            int cur = 0;
            if (s.charAt(idx) == '(') {
                idx++;
                // 递归解决子问题,cur 等于括号内的结果
                cur = helper(s);
            } else {
                while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
                    cur = cur * 10 + s.charAt(idx) - '0';
                    idx++;
                }
            }
            if (sign == '+') {
                ans += cur;
            } else if (sign == '-') {
                ans -= cur;
            }
            if (idx < s.length() && s.charAt(idx) == ')') {
                idx++;
                break;
            }
            // 更新符号
            if (idx < s.length()) {
                sign = s.charAt(idx);
            }
            idx++;
        }
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/basic-calculator/solution/224-ji-ben-ji-suan-qi-zhan-de-shi-yong-by-jasion_h/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

