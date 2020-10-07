#### [236. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/) + 递归寻找二叉树的最近公共祖先

难度：Median

### 解题思路

本题与 `235` 题 **寻找二叉搜索树的最近公共祖先** 很相似，这里说下本题的思路

- 首先对该二叉树的特殊情况进行处理，如果 **为空** 或者公共祖先 **就是** `p` 或 `q` 那直接返回当前结点 `root` 即可

- 接下来就是分别 **递归 **的在 **左右子树中 **寻找公共祖先
- 如果 **没有找到** 则说明不在当前子树中，那么公共祖先就是当前的根节点 `root`

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
        // 这里首先将特殊情况排除
        if (root == null || p == root || q == root) {
            return root;
        }
        // 递归的在左右子树中寻找最近公共祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果左子树没有找到，说明最近公共祖先在右子树
        if (left == null) {
            return right;
        }
        // 反之说明最近公共祖先在左子树
        if (right == null) {
            return left;
        }
        // 左右子树都没有找到最近公共祖先，则说明根节点就是
        return root;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/20200414236mediandi-gui-xun-zhao-er-cha-shu-de-zui/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

