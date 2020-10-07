#### [68. 文本左右对齐](https://leetcode-cn.com/problems/text-justification/) + 细化处理

难度：Hard

### 解题思路

纯细节问题，把握每种情况应该如何应对！

### 代码

```java
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int index = 0;
        int n = words.length;
        while (index < n) {
            int totalChars = words[index].length();
            int last = index + 1;
            
            while (last < n) {
                // 因为两个单词之间必须要有一个空格，所以这里要 + 1,下面亦如此
                if (totalChars + words[last].length() + 1 > maxWidth) {
                    break;
                }
                totalChars += 1 + words[last].length();
                last++;
            }
            
            // 通过上面第二个 while 循环后，last 指向了下一行的第一个单词
            // 可带入数值查看多少个间隔
            int gaps = last - index - 1;
            StringBuilder sb = new StringBuilder();
            
            if (last == n || gaps == 0) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    sb.append(' ');
                }
                // 删除多出来的空格
                sb.deleteCharAt(sb.length() - 1);
                
                // 如果还有剩余位置，就用空格补满
                while (sb.length() < maxWidth) {
                    sb.append(' ');
                }
            } else {
                // 有多少个间隔
                int spaces = (maxWidth - totalChars) / gaps;
                // 有多少空余位置
                int rest = (maxWidth - totalChars) % gaps;
                
                for (int i = index; i < last - 1; i++) {
                    sb.append(words[i]);
                    sb.append(' ');
                    
                    for (int j = 0; j < spaces + (i - index < rest ? 1 : 0); j++) {
                        sb.append(' ');
                    }
                }
                // 因为上面加到 last - 1，所以最后一个单词要单独加上
                sb.append(words[last - 1]);
            }
            ans.add(sb.toString());
            index = last;
        }
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/text-justification/solution/68-wen-ben-zuo-you-dui-qi-xi-hua-chu-li-by-jasion_/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

