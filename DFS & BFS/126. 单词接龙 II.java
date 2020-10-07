#### [126. 单词接龙 II](https://leetcode-cn.com/problems/word-ladder-ii/) + FollowUp法 和 双向高效法

难度：Hard

### 解题思路

本题是单词接龙的变种，如果想要在上一题的前提下求解变种问题可以参考 **解法一** (效率不高)

- **解法二** 给出的是高效率的解法，用到了 `DFS` + `BFS` 双向遍历极大提高了效率

### 代码

解法一：

```java
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        List<List<String>> ans = new ArrayList<>();
        
        Queue<List<String>> q = new LinkedList<>();
        
        Set<String> dict = new HashSet<>();
        for (String word : wordList) {
            dict.add(word);
        }
        
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        q.offer(path);
        
        while (!q.isEmpty()) {
            if (!ans.isEmpty()) {
                return ans;
            }
            int size = q.size();
            for (int i = 0; i < size; i++) {
                List<String> cur = q.poll();
                String curWord = cur.get(cur.size() - 1);
                dict.remove(curWord);
                if (curWord.equals(endWord)) {
                    ans.add(new ArrayList<>(cur));
                } else {
                    StringBuilder sb = new StringBuilder(curWord);
                    for (int j = 0; j < curWord.length(); j++) {
                        for (char c = 'a'; c < 'z'; c++) {
                             if (c == curWord.charAt(j)) {
                                 continue;
                             }
                             sb.setCharAt(j, c);
                             if (dict.contains(sb.toString())) {
                                 cur.add(sb.toString());
                                 q.offer(new ArrayList<>(cur));
                                 cur.remove(cur.size() - 1);
                             }
                        }
                        sb.setCharAt(j, curWord.charAt(j));
                    }
                }
            }
        }
        
        return ans;
    }
}
```



解法二：

```java
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return ans;
        }
        Map<String, List<String>> map = new HashMap<>();
        
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        startSet.add(beginWord);
        endSet.add(endWord);
        
        bfs(startSet, endSet, dict, map, false);
        
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        dfs(ans, list, beginWord, endWord, map);
        return ans;
    }
    
    private void bfs(Set<String> startSet, Set<String> endSet, Set<String> dict, Map<String, List<String>> map, boolean reverse) {
        if (startSet.size() == 0) {
            return;
        }
        
        if (startSet.size() > endSet.size()) {
            bfs(endSet, startSet, dict, map, !reverse);
            return;
        }
        
        Set<String> tmp = new HashSet<>();
        dict.removeAll(startSet);
        boolean finish = false;
        
        for (String s : startSet) {
            char[] chs = s.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                char old = chs[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    chs[i] = c;
                    String word = new String(chs);
                    
                    if (dict.contains(word)) {
                        if (endSet.contains(word)) {
                            finish = true;
                        } else {
                            tmp.add(word);
                        }
                        
                        String key = reverse ? word : s;
                        String val = reverse ? s : word;
                        
                        if (map.get(key) == null) {
                            map.put(key, new ArrayList<>());
                        }
                        map.get(key).add(val);
                    }
                }
                chs[i] = old;
            }
        }
        if (!finish) {
            bfs(tmp, endSet, dict, map, reverse);
        }
    }
    
    private void dfs(List<List<String>> ans, List<String> list, String word, String endWord, Map<String, List<String>> map) {
        if (word.equals(endWord)) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (map.get(word) == null) {
            return;
        }
        
        for (String next : map.get(word)) {
            list.add(next);
            dfs(ans, list, next, endWord, map);
            list.remove(list.size() - 1);
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/word-ladder-ii/solution/126-dan-ci-jie-long-ii-followupfa-xiao-lu-fa-by-ja/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

