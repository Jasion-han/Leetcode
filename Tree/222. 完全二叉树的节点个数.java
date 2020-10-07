#### [222. 完全二叉树的节点个数](https://leetcode-cn.com/problems/count-complete-tree-nodes/) + 递归求解完全二叉树结点个数

难度：Median

### 解题思路

本题使用递归求解，主要思想在于如何递归的求解 **满二叉 **和 **不满二叉 **的情况

- 首先我们知道完全二叉树 **如果有孩子那么一定有左孩子**，不可能出现有左孩子而没有右孩子的情况
- 所以通过遍历每个结点的 **左孩子 **先分别求出左子树和右子树的高度
- 如果`left == right`，说明左子树一定是满二叉树，此时求出左子树的节点总数加上当前子树的根节点，
- 总共为 `2^left` 个，然后再加上递归求解 **右子树** 的个数即可
- 如果`left != right`，说明最后一层不满，但倒数第二层已经满了，此时求出右子树的节点总数加上当前子树的根节点
- 总共为 `2^right` 个，然后再加上递归求解 **左子树** 的个数即可

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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 分别计算左右子树的高度
        int left = count(root.left);
        int right = count(root.right);
        // 如果左右子树高度相等，说明是满二叉树，返回左边的高度再递归遍历右子树
        if (left == right) {
            // 这个位运算是指 2 ^ left
            return (1 << left) + countNodes(root.right);
        } else {
            // 如果不相等，就先求出右子树高度在递归遍历左子树
            return (1 << right) + countNodes(root.left);
        }
    }
    
    private int count(TreeNode node) {
        int level = 0;
        while (node != null) {
            level++;
            // 这里遍历左子树是因为完全二叉树的性质下只要左子树不为空高度就+1
            node = node.left;
        }
        return level;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/count-complete-tree-nodes/solution/20200408222mediandi-gui-qiu-jie-wan-quan-er-cha-sh/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```