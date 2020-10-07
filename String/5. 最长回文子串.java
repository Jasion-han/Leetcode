#### [5. 最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring/) + 中心扩散法

难度：Median

### 解题思路

本题使用中心扩展思路，定义 `i` 为字符串中心点，`l` 和 `r` 分别为回文字段左右两端

分为奇数和偶数两种字符串，`len1` 是奇数个字符串查找方法，`len2` 是偶数个字符串查找方法

找到回文字段后，想清楚l和r的位置，不要多或少字符。

（b站“程序员刀刀”也有讲解）-> 解法二

### 代码

解法一：

```java
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        // 定义回文的起点和终点
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // 奇数，中心点左右两边
            int len1 = expandAroundCenter(s, i - 1, i + 1);
            // 偶数，中心点左右两边
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1,len2);
            if (len > end - start) {
                // 中心点减去回文长度的一半（奇数偶数通用）
                start = i - (len - 1 ) / 2;
                // 中心点加上回文长度的一半
                end = i + len / 2;
            }
        }
        // substring 的性质:左闭右开,所以 end 要 + 1
        return s.substring(start, end + 1);
    }
    
    private int expandAroundCenter(String s, int left, int right){
        int L = left;
        int R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        // 保证传进来的时候的长度
        return R - L - 1;
    }
}
```

解法二：

```java
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        // 定义回文串的左右边界值
        int start = 0;
        int end = 0;
        // 定义最大回文串的个数
        int maxLen = 1;
        
        for (int i = 0; i < s.length(); i++) {
            // 奇数个的情况
            int left = i - 1;
            int right = i + 1;
            // 别落了条件
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                int len = right - left + 1;
                if (len > maxLen) {
                    maxLen = len;
                    start = left;
                    end = right;
                }
                left--;
                right++;
            }
            // 偶数个的情况
            left = i;
            right = i + 1;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                int len = right - left + 1;
                if (len > maxLen) {
                    maxLen = len;
                    start = left;
                    end = right;
                }
                left--;
                right++;
            }
        }
        // substring 的性质:左闭右开,所以 end 要 + 1
        return s.substring(start, end + 1);
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/longest-palindromic-substring/solution/202003105median-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



