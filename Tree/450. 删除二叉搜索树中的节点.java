#### [450. 删除二叉搜索树中的节点](https://leetcode-cn.com/problems/delete-node-in-a-bst/) + 递归删除二叉搜索树的目标结点

难度：Median

### 解题思路

本题利用递归的思想遍历寻找待删除结点

- 寻找待删结点有三种情况：1.待删结点比当前根节点小 2.待删结点比当前根节点大 3.待删结点恰好和当前根节点相等
- 前两种情况通过 **递归** 遍历很好解决，具体看代码，而第三种情况还要细分一下...
- 当找到待删结点时，如果待删结点的右子树为空，则直接返回其左孩子。如果待删结点的右子树不为空，则不断遍历寻找其右子树中最小的结点，找到的最小结点就是要代替删除结点的目标结点。


- 寻找右子树中最小结点的具体过程和释义可看代码注释处。

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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        // 分三种情况 1.key < root.val 2.key > root.val 3.key == root.val
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {            
            if (root.right == null) {
                return root.left;
            } else {
                //如果右子树不为 null，就返回右子树的最小结点
                // 定义 p 不断遍历寻找最小结点，parent 为父节点
                TreeNode parent = root;
                TreeNode p = root.right;
                // 如果 p 有左孩子肯定找比 p 小的作为代替删除结点的目标结点
                while (p != null && p.left != null) {
                    parent = p;
                    p = p.left;
                }
                // 说明 p 有左孩子，上面的 while 执行了
                if (parent.left == p) {
                    parent.left = p.right;
                }
                // 说明 p 没有左孩子，没有执行上面的 while 循环（这两个 if 二选一）
                if (parent.right == p) {
                    parent.right = p.right;
                }
                // 最后将 p 结点代替要删除结点的位置
                p.left = root.left;
                p.right = root.right;
                return p;
            }
        }
       return root; 
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/delete-node-in-a-bst/solution/20200413450mediandi-gui-shan-chu-er-cha-sou-suo-sh/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

