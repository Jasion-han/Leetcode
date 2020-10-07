#### [214. 最短回文串](https://leetcode-cn.com/problems/shortest-palindrome/) + 拼接手法

难度：Hard

### 解题思路

使用 [前缀 + 中间部分 + 后缀] 拼接而成

### 代码

```java
class Solution {
    public String shortestPalindrome(String s) {
        int i = 0;
        int n = s.length();
        for (int j = n - 1; j >= 0; j--) {
            if (s.charAt(i) == s.charAt(j)) {
                i += 1;
            }
        }
        // 经过上面走完后，i 位于回文串的最后一位，例如：
        // aacecaaa
        //        i
        if (i == n) {
            return s;
        }
        
        // 定义后缀，中间部分，前缀，最后拼接起来即可
        String suffix = s.substring(i);
        // substring() 左闭右开原则，所以这里取不到最后的 a
        String mid = shortestPalindrome(s.substring(0,i));
        String prefix = new StringBuilder(suffix).reverse().toString();
        String ans = prefix + mid + suffix;
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/shortest-palindrome/solution/214-zui-duan-hui-wen-chuan-pin-jie-shou-fa-by-jasi/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

