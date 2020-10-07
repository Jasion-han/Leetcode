#### [65. 有效数字](https://leetcode-cn.com/problems/valid-number/) + String, Math

难度：Hard

### 解题思路

- 先大致划分为 `4` 种可行性情况，然后具体分析
- 注意最后结束返回的条件！

### 代码

```java
class Solution {
    public boolean isNumber(String s) {
        // 首先去除空格
        s = s.trim();
        
        boolean eSeen = false;
        boolean numSeen = false;
        boolean pointSeen = false;
        boolean numAfterE = false;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c >= '0' && c <= '9') {
                numSeen = true;
                numAfterE = true;
            } else if (c == 'e') {
                // 每个有效数字里只能有一个 e,且前面已经出现过数字
                if (eSeen || !numSeen) {
                    return false;
                }
                eSeen = true;
                numAfterE = false;
            } else if (c == '+' || c == '-') {
                // 只能出现在首位或者 e 后面
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else if (c == '.') {
                // 只能出现在 e 前面且 point 只能有一个
                if (eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else {
                return false;
            }
        }
        // 排除 “e1” 或者 “-1” 这两‘类’特殊情况
        return numAfterE && numSeen;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/valid-number/solution/65-you-xiao-shu-zi-stringmath-by-jasion_han/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

