#### [22. 括号生成](https://leetcode-cn.com/problems/generate-parentheses/) + 递归回溯

难度：Median

### 解题思路

- 主要画出括号匹配树
- 分别用 `left` 和 `right` 记录左右括号剩余的个数

- 并且注意最后左括号剩余的个数要严格小于右括号，否则就无法正确匹配。

### 代码

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n <= 0) {
            return ans;
        }
        dfs(ans, "", n, n);
        return ans;
    }
    
    // left 和 right 代表左右括号的剩余匹配个数
    private void dfs(List<String> ans, String s, int left, int right) {
        // System.out.println(s); 可进行输出查看
        if (left == 0 && right == 0) {
            ans.add(s);
            return;
        }
        if (left > 0) {
            dfs(ans, s + '(', left - 1, right);
        }
        // 最后必须满足左括号剩余个数严格小于右括号个数
        if (right > 0 && left < right) {
            dfs(ans, s + ')', left, right - 1);
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/generate-parentheses/solution/22-gua-hao-sheng-cheng-di-gui-hui-su-by-jasion_han/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

