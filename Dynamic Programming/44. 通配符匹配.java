#### [44. 通配符匹配](https://leetcode-cn.com/problems/wildcard-matching/) + 四大指针齐发力

难度：Hard

### 解题思路

- 依据本题匹配规则，当 `p` 中未出现 `*` 的时候，只需使用移动指针 `sp` 和 `pp` 即可
- 但当 `pp` 遇到 `*` 的时候就需要再定义额外两个指针在 `s` 字符串中找与之匹配的字符串

- 最后细节：在 `p` 中匹配完所有字母的时候，若剩余 `*` 未匹配则将指针移动到末尾为了结果的统一

### 代码

```java
class Solution {
    public boolean isMatch(String s, String p) {
        // 定义移动指针 sp 和 pp
        // 定义 s 中待匹配的 match 指针和在 p 中寻找匹配的指针 start
        int sp = 0;
        int pp = 0;
        int match = 0;
        int start = -1;
        
        while (sp < s.length()) {
            // 如果字母相匹配或者 p 中是 '?' 说明匹配成功
            if (pp < p.length() && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?')) {
                sp++;
                pp++;
            // 如果 p 遇到 '*' 那么需要借用 match 指针在 s 中找能匹配的字符串
            } else if (pp < p.length() && p.charAt(pp) == '*') {
                start = pp;
                match = sp;
                pp++;
            // 在找寻 '*' 匹配字符串的过程中
            } else if (start != -1) {
                pp = start + 1;
                match++;
                sp = match;
            } else {
                return false;
            }
        }
        // 最后如果 p 匹配完所有字母后还剩下 '*' 未匹配则要移动 pp 指针到最后，为了使最后返回结果统一
        while (pp < p.length() && p.charAt(pp) == '*') {
            pp++;
        }
        
        return pp == p.length();
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/wildcard-matching/solution/44-tong-pei-fu-pi-pei-si-da-zhi-zhen-qi-fa-li-by-j/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

