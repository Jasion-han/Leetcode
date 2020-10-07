#### [282. 给表达式添加运算符](https://leetcode-cn.com/problems/expression-add-operators/) + 回溯分情况防溢出

难度：Hard

### 解题思路

- 这里需要使用 **多个参数** 进行计算
- 特别注意

1. 递归的出口
2. 大于 `1` 位的数不能以 `0` 开头
3. 防止越界换用 `long` 类型存储

4. 遇到 **先加法后乘法** 的运算，应该减去加号后面的数字 **先进行乘法运算** 后进行加法运算

### 代码

```java
class Solution {
    public List<String> addOperators(String s, int target) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return ans;
        }
        backtrack(s, target, ans, "", 0, 0, 0);
        return ans;
    }
    
    private void backtrack(String s, int target, List<String> ans, String path, int pos, long val, long pre) {
        // 递归出口
        if (pos == s.length()) {
            if (val == target) {
                ans.add(path);
                return;
            }
            return;
        }
        
        for (int i = pos; i < s.length(); i++) {
            // 大于 1 位的数不能以 0 开头
            if (i != pos && s.charAt(pos) == '0') {
                break;
            }
            // 这里防止越界需要换用 long 类型,后面 substring 语法需要左闭右开
            Long cur = Long.parseLong(s.substring(pos, i + 1));
            if (pos == 0) {
                          // 倒数第二个参数 val 对应的值此时是 cur 
                backtrack(s, target, ans, path + cur, i + 1, cur, cur);
            } else {
                backtrack(s, target, ans, path + "+" + cur, i + 1, val + cur, cur);
                backtrack(s, target, ans, path + "-" + cur, i + 1, val - cur, -cur);
                // 注意这里倒数第二个参数，需要将前一个数值减掉先进行后面的乘法操作然后再与之前的数相加
                // 例如：" 2 + 3 * 2",当 val 是 2 + 3 = 5 的时候需要 - 3,先让 3 * 2 计算,然后再和前面的 2 相加
                backtrack(s, target, ans, path + "*" + cur, i + 1, val - pre + pre * cur, pre * cur);
            }
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/expression-add-operators/solution/282-gei-biao-da-shi-tian-jia-yun-suan-fu-hui-su-fe/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

