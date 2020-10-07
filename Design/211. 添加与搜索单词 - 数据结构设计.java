#### [211. 添加与搜索单词 - 数据结构设计](https://leetcode-cn.com/problems/design-add-and-search-words-data-structure/) + 数据结构设计 + 辅助结构体，函数设计法

难度：Median

### 解题思路

- 本题创建 **结构体** 和 `find` **方法体** 帮助完成设计，具体看代码即可。

### 代码

```java
class WordDictionary {
    
    // 创建结构体
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
    
    // 全局声明一个根节点，后面的方法会用到该节点
    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            // 如果该索引下还没有节点，就新建一个节点
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            // 如果有节点就跳到孩子节点去
            node = node.children[index];
        }
        // 单词更新为 true
        node.isWord = true;
        node.word = word;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return find(word, root, 0);
    }
    
    // 创建辅助方法函数
    public boolean find(String word, TrieNode node, int index) {
        if (node == null) {
            return false;
        }
        // 当遍历完整个单词，就返回查看是否是单词即可
        if (index == word.length()) {
            return node.isWord;
        }
        // 如果遇见 "."
        if (word.charAt(index) == '.') {
            // 就循环遍历他的孩子，直到最后判断 find 出来的结果是否为 true 即可判断是否满足要求
            for (TrieNode tmp : node.children) {
                if (find(word, tmp, index + 1)) {
                    return true;
                }
            }
        // 如果遇见的是字母
        } else {
            int tmpIndex = word.charAt(index) - 'a';
            TrieNode tmp = node.children[tmpIndex];
            return find(word, tmp, index + 1);
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

作者：Jasion_han
链接：https://leetcode-cn.com/problems/design-add-and-search-words-data-structure/solution/211-tian-jia-yu-sou-suo-dan-ci-shu-ju-jie-gou-s-11/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

