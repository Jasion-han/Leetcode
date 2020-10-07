#### [87. 扰乱字符串](https://leetcode-cn.com/problems/scramble-string/) + DFS，剪枝

难度：Hard

### 解题思路

印度小哥代码，简洁易懂！

### 代码

```java
class Solution {
    public boolean isScramble(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        // 判断特殊条件
        if (m != n) {
            return false;
        }
        if (m == 0) {
            return true;
        }
        if (s1.equals(s2)) {
            return true;
        }
        // 记录字母
        int[] count = new int[26];
        for (int i = 0; i < m; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < m; i++) {
            if (count[s1.charAt(i) - 'a'] != 0) {
                return false;
            }
        }
        // 这里要从 i = 1 开始进行左右分割(以间隙为分割标准),所以要从 1 开始
        for (int i = 1; i < m; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) && isScramble(s1.substring(i), s2.substring(0, n - i))) {
                return true;
            }
        }
        return false;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/scramble-string/solution/87-rao-luan-zi-fu-chuan-dfsjian-zhi-by-jasion_han/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

