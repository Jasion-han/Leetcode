#### [394. 字符串解码](https://leetcode-cn.com/problems/decode-string/) + 四种情况以及括号内调用自己

难度：Median

### 解题思路

- 本题主要以 **四种情况** 作为讨论点，明确每步的操作是什么

- 注意遇到左括号的时候里面可能继续 **嵌套着括号**，所以应该使用 **递归** 调用自己完成子问题的操作

### 代码

```java
class Solution {
    
    // 定义从 0 开始的索引指针
    int idx = 0;
    
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        while (idx < n) {
            // 记录数字的个数
            int times = 0;
            while (idx < n && ch[idx] >= '0' && ch[idx] <= '9') {
                times = times * 10 + ch[idx] - '0';
                idx++;
            }
            // 左括号
            if (ch[idx] == '[') {
                idx++;
                // 进入括号如果里面还嵌套着括号，就递归调用自己
                String word = decodeString(s);
                // times 是几就加几遍该字母
                while (times > 0) {
                    sb.append(word);
                    times--;
                }
            // 右括号
            } else if (ch[idx] == ']') {
                idx++;
                return sb.toString();
            // 正常字母
            } else {
                sb.append(ch[idx]);
                idx++;
            }
        }
        return sb.toString();
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/decode-string/solution/394-zi-fu-chuan-jie-ma-si-chong-qing-kuang-yi-ji-g/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

