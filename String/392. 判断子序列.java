#### [392. 判断子序列](https://leetcode-cn.com/problems/is-subsequence/) + 基础双指针法对应匹配

难度：Easy

### 解题思路

定义两字符串指针分别从头遍历，基础算法，看代码。

### 代码

```java
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        
        int sp = 0;
        int tp = 0;
        
        while (tp < t.length()) {
            if (s.charAt(sp) == t.charAt(tp)) {
                sp++;
                // 如果 sp 走到了最后，说明都匹配成功了
                if (sp == s.length()) {
                    return true;
                }
            }
            tp++;
        }
        return false;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/is-subsequence/solution/392-pan-duan-zi-xu-lie-dui-ying-pi-pei-by-jasion_h/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

