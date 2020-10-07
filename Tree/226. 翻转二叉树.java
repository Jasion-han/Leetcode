#### [226. 翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/) + 基础递归

难度：Easy

### 解题思路

本题巧用递归的思想很好解决问题

- 将二叉树的**左右子树依次翻转**
- 等翻转过后再用**根节点连不同的子树**即可。

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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 将左右子树翻转
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        // 然后根节点左连右子树，右连左子树
        root.left = right;
        root.right = left;
        
        return root;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/invert-binary-tree/solution/20200407226easydi-gui-fan-zhuan-er-cha-shu-by-jasi/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

