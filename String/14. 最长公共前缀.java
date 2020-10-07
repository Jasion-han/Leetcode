#### [14. 最长公共前缀](https://leetcode-cn.com/problems/longest-common-prefix/) + 基础遍历

难度：Easy

### 解题思路

暂无

### 代码

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 将第一个元素作为前缀
        String prefix = strs[0];
        // 从第二个元素开始遍历
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            // 当 j 小于每个元素长度，小于前缀元素长度，且前缀元素与当前元素有相同字母
            while (j < strs[i].length() && j < prefix.length() && strs[i].charAt(j) == prefix.charAt(j)) {
                // 则继续对比更多字母
                j++;
            }
            // 如果 j 没有匹配到相同字母元素，则说明无结果
            if (j == 0) {
                return "";
            }
            // 取公共字母作为前缀返回即可。
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/longest-common-prefix/solution/14zui-chang-gong-gong-qian-zhui-by-jasion_han/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

