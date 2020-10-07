#### [58. 最后一个单词的长度](https://leetcode-cn.com/problems/length-of-last-word/) + 基础 for 循环

难度：Easy

### 解题思路

暂无

### 代码

```java
class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        // 定义最后一个单词的长度
        int length = 0;
        // 从后往前遍历
        for (int i = s.length() - 1; i >= 0; i--) {
            if (length == 0) {
                if (s.charAt(i) == ' ') {
                    continue;
                } else {
                    length++;
                }
            } else {
                if (s.charAt(i) == ' ') {
                    break;
                } else {
                    length++;
                }
            }
        }
        return length;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/length-of-last-word/solution/58zui-hou-yi-ge-dan-ci-de-chang-du-by-jasion_han/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

