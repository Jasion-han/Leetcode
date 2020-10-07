#### [151. 翻转字符串里的单词](https://leetcode-cn.com/problems/reverse-words-in-a-string/) + 151.翻转字符串里的单词 和186. 翻转字符串里的单词 II

难度：Median

### 解题思路

`T151` 翻转字符串里的单词:

- 注意存放的是 **单词**，所以要用 `String[]` 来接收， 如果是 **单个字符**，才用 `char[]` 来接收
- 因为是 **单词**，所以要用 **双引号** `“”` 来指代空字符串， 而 **单个字符 **应该用 **单引号** `‘’` 来指代空字符

- 注意这里的 `s.trim().split(" ");` ---> `strim()` 和 `split(" ")`不能颠倒顺序！

`T186` 翻转字符串里的单词 `II`:

- 先对 **每一个单词** 实现翻转，再对 **整个数组** 实现翻转。
- 这样单词实现了两次翻转，所以单词个体的顺序仍不变，但单词间的顺序发生了变化。

### 代码

T151:

```java
class Solution {
    // T151
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        // 删除首尾空格，分割字符串
        String[] arr = s.trim().split(" ");
        
        StringBuilder ans = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            // 遇到空单词则跳过
            if (arr[i].equals("")) {
                continue;
            }
            // 将单词拼接至 ans
            ans.append(arr[i] + " ");
            
        }
        // 转化为字符串，删除尾部空格，并返回
        return ans.toString().trim();
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/reverse-words-in-a-string/solution/151fan-zhuan-zi-fu-chuan-li-de-dan-ci-stringbuilde/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



T186:

```java
class Solution {
    // T186
    public void reverseWords(char[] str) {
        // 2ms
        // 原地修改，通过翻转实现
        if (str.length==0) {
            return;
        } 
        int index = 0;
        for (int i = 0; i <= str.length; i++) {
            // 空格之前或者最后一个元素之前分割为一个单词
            if (i == str.length || str[i] == ' ') {
                // 对每一个单词实现翻转
                reverse(str, index, i); 
                // 索引移动到下一个单词的起始位置
                index = i + 1;
            }
        }
        // 整体翻转
        reverse(str, 0, str.length); 
    }
    
    private void reverse(char[] str, int start, int end){
        // 定义 cnt 代表 i 每向后移动一步尾指针就向前移一步
        int cnt = 0;
        // 对每个单词的前一半翻转即可
        for (int i = start; i < start + (end - start) / 2; i++) {
            char temp = str[i];
            str[i] = str[(end - 1) - cnt];
            str[(end - 1) - cnt] = temp;
            cnt++;
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/reverse-words-in-a-string/solution/151fan-zhuan-zi-fu-chuan-li-de-dan-ci-stringbuilde/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

