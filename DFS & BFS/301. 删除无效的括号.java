#### [301. 删除无效的括号](https://leetcode-cn.com/problems/remove-invalid-parentheses/) + 递归，反转左右括号

难度：Hard

### 解题思路

核心思想是将多出来的右括号进行删除，如果左括号大于右括号，进行反转后与之前步骤统一处理

### 代码

```java
class Solution {
    
    // 定义两种模式，分别是记录 右括号比左括号多 和 左括号比右括号多 的时候
    char[][] patterns = {{'(', ')'}, {')', '('}};
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() == 0) {
            ans.add("");
            return ans;
        }
        dfs(s, ans, 0, patterns[0]);
        return ans;
    }
    
    private void dfs(String s, List<String> ans, int lastRemove, char[] pattern) {
        int cnt = 0;
        int i = 0;
        // i 没有走到最右边 且 右括号不比左括号多
        while (i < s.length() && cnt >= 0) {
            // pattern[0]代表 '('
            if (s.charAt(i) == pattern[0]) {
                cnt++;
            }
            // pattern[1]代表 ')'
            if (s.charAt(i) == pattern[1]) {
                cnt--;
            }
            i++;
        }
        
        // cnt < 0 表示右括号大于左括号即需要去除多余的右括号
        if (cnt < 0) {
            // j 从上一次移除的位置开始扫描到当前所在的位置
            for (int j = lastRemove; j < i; j++) {
                // 如果遍历到的是右括号，并且指向的是需要移除的位置或者前一个位置元素不是右括号
                // 例如 ())
                //       j
                if (s.charAt(j) == pattern[1] && (j == lastRemove || s.charAt(j - 1) != pattern[1])) {
                    dfs(s.substring(0, j) + s.substring(j + 1), ans, j, pattern);
                }
            }
        // 当 i 走到最右边时,表示左括号大于右括号
        } else {
            // 该步骤是为了使 (() 这种左括号多的时候进行反转达到统一处理右括号的目的
            String reverse = new StringBuilder(s).reverse().toString();
            if (pattern[0] == '(') {
                dfs(reverse, ans, 0, patterns[1]);
            } else {
                ans.add(reverse);
            }
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/remove-invalid-parentheses/solution/301-shan-chu-wu-xiao-de-gua-hao-di-gui-fan-zhuan-z/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

