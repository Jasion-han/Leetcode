#### [125. 验证回文串](https://leetcode-cn.com/problems/valid-palindrome/) + 头尾双指针法

难度：Easy

### 解题思路

本题是使用 **双指针法**，一左一右依次遍历整个字符串

通过 `while` 循环先将不满足题意的情况给排除掉，剩下的可以都转化成小写或大写进行比较，最终得到结果。

### 代码

```java
class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int l = 0;
        int r = s.length() - 1;
        while(l < r){
            //过滤掉不是字母或数字的元素
            while(l < r && !Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }
            while(l < r && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }
            //都转化成小写进行比较
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/valid-palindrome/solution/20200320125easy-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

