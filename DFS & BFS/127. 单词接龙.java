#### [127. 单词接龙](https://leetcode-cn.com/problems/word-ladder/) + BFS+Set单词接龙

难度：Median

### 解题思路

本题较为复杂，使用了多个 `Set` 和 `for` 循环来共同完成。

一开始定义一个大的 `Set` 存放 `List` 中所有的元素，并做 **判空** 操作

其中最主要的思想就是定义两个 `Set` 来从两端进行 `BFS` **双向交替遍历**，然后注意三层 `for` 循环的使用方法

最后当 `s2` 包含了当前所遍历的 `tmp` 就返回 `step + 1` 即可，具体请看代码注释部分。

### 代码

解法一：

```java
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 创建 set 存放 wordList 中的元素
        Set<String> wordSet = new HashSet<>(wordList.size());
        wordSet.addAll(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        // 创建两个 set 双向交替遍历
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        s1.add(beginWord);
        s2.add(endWord);
        int len = beginWord.length();
        // 记录转换次数
        int step = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            step++;
            // 优化:每次将一个短的 set 遍历完再遍历另一个
            // 这里将短的定义为 s1 方便统一操作
            if (s1.size() > s2.size()) {
                Set<String> tmp = s1;
                s1 = s2;
                s2 = tmp;
            }
            // 创建新的 set 来存储变化后的元素,保持 s1 原有的元素不变
            Set<String> s = new HashSet<>();
            // 三层循环:第一层遍历 s1 中的每个元素（前面已经把 s1 设定成最短的了）
            // 第二层遍历当前元素的每个字母并转成字符数组存储
            // 第三层将每个字母循环变成 a~z 来和 wordSet 中的元素做匹配
            for (String word : s1) {
                for (int i = 0; i < len; i++) {
                    char[] chs = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chs[i] = c;
                        // 创建 tmp 每次都临时记录变换后的元素
                        String tmp = new String(chs);
                        if (s2.contains(tmp)) {
                            return step + 1;
                        }
                        // 如果 set 里面本就没有当前 tmp 所变换的元素，那就继续下一次循环
                        if (!wordSet.contains(tmp)) {
                            continue;
                        }
                        // 如果 s2 中不包含 tmp 所指的元素,但 set 中有这个元素
                        // 则将该元素移出 set 以免被多次访问,并将其放入到 s1 中继续遍历
                        wordSet.remove(tmp);
                        s.add(tmp);
                    }
                }
            }
            // 将变换后的 s 更新给 s1 继续下一轮遍历
            s1 = s;
        }
        return 0;
    }
}
```

解法二：

```java
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 使用 set 先将 wordList 里面的字符串放进去
        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        
        // 定义层数(即最终长度),字母的转变看似一棵树
        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                // 将出队单词的每个字母进行转换对比
                for (int j = 0; j < cur.length(); j++) {
                    // 用字符数组存储每个字母
                    char[] ch = cur.toCharArray();
                    for (char x = 'a'; x <= 'z'; x++) {
                        ch[j] = x;
                        // 定义 tmp 指代替换字母后的单词
                        String tmp = new String(ch);
                        if (set.contains(tmp)) {
                            // 如果在 set 中找到了该单词并且是最后一个
                            if (tmp.equals(endWord)) {
                                return level + 1;
                            }
                            q.offer(tmp);
                            set.remove(tmp);
                        }
                    }
                }
            }
            // 本层结束,继续到下一层遍历
            level++;
        }
        return 0;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/word-ladder/solution/20200406127medianbfssetdan-ci-jie-long-by-jasion_h/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

