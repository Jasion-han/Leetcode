#### [104. 二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/) + 基础递归

难度：Easy

### 解题思路

本题为**二叉树和递归结合**的基础题

- 首先要对数**判空**，给程序设定一个出口
- 然后递归的求解**左右子树**各自的最大深度
- 最后返回两者中最大的深度**加上根节点**的 `1` 即为最大深度。

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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 分别递归求左右子树的深度
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // 最后将两者最大的深度再加上根节点即为最大深度
        return Math.max(left, right) + 1;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/20200407104easyer-cha-shu-di-gui-qiu-jie-zui-da-sh/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

