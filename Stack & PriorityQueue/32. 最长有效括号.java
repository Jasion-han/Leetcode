#### [32. 最长有效括号](https://leetcode-cn.com/problems/longest-valid-parentheses/) + 栈的使用

难度：Hard

### 解题思路

- 入栈的情况要搞清楚
- 一开始先要把最左边括号前的索引 `-1` 压入栈中为了后续计算括号匹配的最长长度

- 具体请看代码注释

### 代码

```java
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        // 最左边括号前的索引先压入栈
        // 为了之后的取差值方便计算
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            // 如果是左括号，就把当前的下标入栈
            if (s.charAt(i) == '(') {
                stack.push(i);
            // 如果是右括号
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    // 例如 ( ( )
                    //      0   2
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/longest-valid-parentheses/solution/32-zui-chang-you-xiao-gua-hao-by-jasion_han/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

