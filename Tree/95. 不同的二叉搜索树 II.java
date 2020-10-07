#### [95. 不同的二叉搜索树 II](https://leetcode-cn.com/problems/unique-binary-search-trees-ii/) + 每个节点都当根时左右子树节点个数

难度：Median

### 解题思路

- 让每个节点都当根，然后用 `list` 保存此时左右子树节点的个数
- 然后双重 `for` 循环构建不同的树

- 注意放 `null` 时的情况

### 代码

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        // 从 1 到 n 每个节点当根时所构建的树
        return helper(1, n);
    }
    
    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        // 不满足的地方填 null
        if (start > end) {
            ans.add(null);
            return ans;
        }
        
        // 每个 i 当根节点时计算左右子树中节点的个数
        for (int i = start; i <= end; i++) {
            // 左子树所有节点
            List<TreeNode> leftNodes = helper(start, i - 1);
            // 右子树所有节点
            List<TreeNode> rightNodes = helper(i + 1, end);
            
            // 左右子树不同节点构建成不同的树
            for (TreeNode left : leftNodes) {
                for (TreeNode right : rightNodes) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii/solution/95-bu-tong-de-er-cha-sou-suo-shu-ii-mei-ge-jie-dia/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

