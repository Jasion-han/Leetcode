#### [208. 实现 Trie (前缀树)](https://leetcode-cn.com/problems/implement-trie-prefix-tree/) + 创建结构体后续方便操作

难度：Median

### 解题思路

- 该题和 `211` 很相似，还要稍简单点
- 注意 **查找** 和 **以某些字母开头查找** 在 **返回** 时候的区别

### 代码

```java
class Trie {
    
    // 创建 TrieNode 结构体
    private class TrieNode{
        public TrieNode[] children;
        public boolean isWord;
        public String word;
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
            word = "";
        }
    }
    
    // 创建根节点，后续会用到
    public TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            // 一旦开头就没有,后面也不用查了,直接返回 false 即可
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        // 在查找结尾需要判断是否是个单词
        return node.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            // 一旦开头就没有,后面也不用查了,直接返回 false 即可
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        // 而在判断是否以某些字母开始的时候不需要判断最终是否是个单词就能直接返回 true
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

作者：Jasion_han
链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/208-shi-xian-trie-qian-zhui-shu-chuang-jian-jie-go/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

