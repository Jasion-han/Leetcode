#### [212. 单词搜索 II](https://leetcode-cn.com/problems/word-search-ii/) + 字典树构建，棋盘遍历

难度：Hard

### 解题思路

- 本题是综合了 **字典树的构建** 和 **扫描棋盘** 的题目
- 首先我们应该使用字典树构建的方法将字母与字母的 **关系** 找到
- 然后通过 `DFS` 遍历类似于 **棋盘** 的写法搜集目标单词集合并最终返回即可。

### 代码

```java
class Solution {
    
    // 创建 TrieNode 结构体
    private class TrieNode{
        public TrieNode[] children;
        public String word;
        public TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        // 创建字典树
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, ans, root, i, j);
            }
        }
        return ans;
    }
    
    private TrieNode buildTrie(String[] words) {
        // 创建根节点
        TrieNode root = new TrieNode();
        for (String word : words) {
            // 定义移动指针从 root 开始构建孩子节点
            TrieNode node = root;
            
            // for (int i = 0; i < word.length(); i++) {
            // int index = word.charAt(i) - 'a';
            // 这两行可替代下面前两行,写法上和 208 题一致
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = word;
        }
        return root;
    }
    
    private void dfs(char[][] board, List<String> ans, TrieNode node, int i, int j) {
        // 和 79 题相似做法，上下左右寻找满足要求的元素
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        
        char c = board[i][j];
        
        // 如果遇到已经遍历过的字母或者原数据中本就不存在该字母,直接返回
        if (c == '#' || node.children[c - 'a'] == null) {
            return;
        }
        
        node = node.children[c - 'a'];
        if (node.word != null) {
            ans.add(node.word);
            // 这里相当于回溯的写法,为了使寻找下个单词的时候可以继续使用
            node.word = null;
        }
        board[i][j] = '#';
        dfs(board, ans, node, i + 1, j);
        dfs(board, ans, node, i - 1, j);
        dfs(board, ans, node, i, j + 1);
        dfs(board, ans, node, i, j - 1);
        board[i][j] = c;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/word-search-ii/solution/212-dan-ci-sou-suo-ii-zi-dian-shu-gou-jian-qi-pan-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

