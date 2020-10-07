#### [140. 单词拆分 II](https://leetcode-cn.com/problems/word-break-ii/) + 分治递归法

难度：Hard

### 解题思路

最主要是抓住每个子串的遍历范围，具体请看代码

### 代码

```java
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        // 将题目中 wordDict 里面的单词放到 set 中
        Set<String> dict = new HashSet<>();
        for (String word : wordDict) {
            dict.add(word);
        }
        
        Map<Integer, List<String>> records = new HashMap<>();
        return helper(s, dict, records, 0);
    }
    
    private List<String> helper(String s, Set<String> dict, Map<Integer, List<String>> records, int start) {
        if (records.containsKey(start)) {
            // 直接返回从 start 开始的 list
            return records.get(start);
        }
        
        List<String> ans = new ArrayList<>();
        
        for (int i = start + 1; i < s.length(); i++) {
            // 如果 dict 中有这个单词
            if (dict.contains(s.substring(start, i))) {
                // 建立 sb 并且把该单词放进去
                StringBuilder sb = new StringBuilder(s.substring(start, i));
                // 递归遍历剩下的子串
                List<String> remain = helper(s, dict, records, i);
                for (String r : remain) {
                    sb.append(" ");
                    sb.append(r);
                    ans.add(sb.toString());
                    // 初始化 sb 的长度，否则会一直往后面加元素
                    sb = new StringBuilder(s.substring(start, i));
                }
            }
        }
        // 看看 s 结尾是否是一个单词
        if (dict.contains(s.substring(start, s.length()))) {
            ans.add(s.substring(start, s.length()));
        }
        
        records.put(start, ans);
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/word-break-ii/solution/140-dan-ci-chai-fen-ii-fen-zhi-di-gui-fa-by-jasion/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

