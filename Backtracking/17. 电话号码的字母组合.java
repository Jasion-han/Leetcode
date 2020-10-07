#### [17. 电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/) + 回溯法寻找电话号码的字母组合

难度：Median

### 解题思路

本题是 **递归和回溯** 的结合题

- 一开始定义全局变量 `ans` 来接收最后的目标组合，`str` 来存放当前数字下可能表示的字母组合，`num` 来列举数字代表的字母

- 然后 **判空**之后进入 **回溯方法体**，说明方法体的出口即遍历到的数字长度和给定的数字 **长度相等** 即可返回
- 接下来就是重中之重：
- 创建一个字符数组来存放每个数字代表的字母，然后添加至 `str`，之后再递归的将下一个数字代表的字母放入 `str` 进行组合，当最后一个数字的字母遍历完后就回退到前一个数字的下一个字母继续组合，直到所有数字代表的字母都被组合完毕即可。


### 代码

解法一：

```java
class Solution {
    // 定义 ans 来接收结果
    List<String> ans = new ArrayList<>();
    // 定义可变字符串 str 来存储当前数字代表的所有字母
    StringBuilder str = new StringBuilder();
    String digits;
    String[] num;
    
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        this.digits = digits;
        
        num = new String[]{"abc",
                           "def",
                           "ghi",
                           "jkl",
                           "mno",
                           "pqrs",
                           "tuv",
                           "wxyz"};
        
        back(0);
        return ans;
    }
    // 回溯
    private void back(int index) {
        if (index == digits.length()) {
            ans.add(str.toString());
            return;
        }
        // 将每个输入的数字代表的字母放入字符数组
        char[] ch = num[digits.charAt(index) - '2'].toCharArray();
        // 遍历这个字符数组依次添加至 str
        for (char c : ch) {
            str.append(c);
            back(index + 1);
            // 回退上一个字母
            str.deleteCharAt(str.length() - 1);
        }
    }
}
```

解法二：

```java
class Solution {
    
    // 从 0 ~ 9 对应的字母用 keyBoard 保存
    String[] keyBoard = new String[]{" ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        StringBuilder sb = new StringBuilder();
        backtrack(digits, ans, sb, 0);
        return ans;
    }
    
    private void backtrack(String digits, List<String> ans, StringBuilder sb, int index) {
        // 如果 index 已经达到 digits 的长度则将 sb 中的内容放入 ans
        if (index == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        // 取出 keyBoard 中对应数字的字符串
        String letters = keyBoard[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            char c = letters.charAt(i);
            sb.append(c);
            backtrack(digits, ans, sb, index + 1);
            // 回溯,去除当前 sb 中最后一个元素然后进行下一轮的添加
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/2020041617medianhui-su-fa-xun-zhao-dian-hua-hao-ma/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

