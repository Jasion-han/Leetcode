#### [235. 二叉搜索树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/) + 递归遍历二叉搜索树最近公共祖先

难度：Easy

### 解题思路

本题要求 **最近**的公共祖先，想到以下几种情况：

- 首先对该树 **判空**
- 如果两个指定节点都位于当前根节点的 **左侧**，那么就递归遍历 **左侧**，因为最近的公共祖先 **一定位于左子树**

- 如果两个指定节点都位于当前根节点的 **右侧**，那么就递归遍历 **右侧**，因为最近的公共祖先 **一定位于右子树**
- 另外三种特殊情况：1.`p` 就是根节点，2.`q` 就是根节点，3.两指定结点 **均位于 **根节点的 **左右两侧**
- 那么这三种情况下的最近公共祖先就只有 **根节点 ** root 了，返回 **root** 即可。

### 代码

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // 如果两个指定的结点都在当前根节点左侧
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // 如果两个指定的结点都在当前根节点右侧
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // 其他情况包括 p 就是根节点，q就是根节点，两结点在根节点的左右两侧
        // 那么这三种情况下最近公共祖先就只有根节点 root 了。
        return root;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/solution/20200411235easydi-gui-bian-li-er-cha-sou-suo-shu-z/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

