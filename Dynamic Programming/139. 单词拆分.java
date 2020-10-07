#### [139. 单词拆分](https://leetcode-cn.com/problems/word-break/) + 动态规划依次匹配单词

难度：Median

### 解题思路

- 本题想法就是对字符串 `s` 遍历

- 然后每次判断从 `0` 开始到 **当前遍历位置** `i` 是否有匹配的单词在 `wordDict` 中即可。

### 代码

```java
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            // 从 0 到 i 寻找是否有对应的单词在 wordDict 中
            for (int j = 0; j < i; j++) {
                // 如果 0 ~ j 部分的单词命中，并且 j ~ i 部分的单词也在其中
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        // 最后返回整个字符串是否都有对应单词在 wordDict 中即可
        return dp[s.length()];
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/word-break/solution/139-dan-ci-chai-fen-dong-tai-gui-hua-yi-ci-pi-pei-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

