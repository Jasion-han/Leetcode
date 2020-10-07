#### [388. 文件的最长绝对路径](https://leetcode-cn.com/problems/longest-absolute-file-path/) + 字符串分割入栈

难度：Median

### 解题思路

- 本题使用分割思想将原字符串按换行进行分割，然后遍历每部分字符串
- 最后就是 `len` = 上一层目录长度 + 文件名 + （`level-1`）个 `"/"`

### 代码

```java
class Solution {
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int ans = 0;
        // 以 \n 分割成字符串数组
        String[] str = input.split("\n");
        // dir,\tsubdir1,\tsubdir2,\tfile.ext
        for (String s : str) {
            // level 代表当前字符串的首字母索引
            // 字符串前面可能会有多个 \t,故使用 lastIndexOf 找出最后一个 \t 位置即可
            int level = s.lastIndexOf("\t") + 1;
            while (level + 1 < stack.size()) {
                stack.pop();
            }
            // 之前入栈的字符串 + 当前遍历到的字符串的长度
            int len = stack.peek() + (s.length() - level + 1);
            stack.push(len);
            if (s.contains(".")) {
                ans = Math.max(ans, len - 1);
            }
        }
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/longest-absolute-file-path/solution/388-wen-jian-de-zui-chang-jue-dui-lu-jing-zi-fu-ch/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

