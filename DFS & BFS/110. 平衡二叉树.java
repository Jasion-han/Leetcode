#### [110. 平衡二叉树](https://leetcode-cn.com/problems/balanced-binary-tree/) + 自底向上递归判断平衡二叉树

难度：Easy

### 解题思路

本题使用最优解 **自底向上**判断一棵树是否为平衡二叉树

- 首先创建 **递归方法体**，返回值为 `int` 类型
- 方法体里面先对传进来的结点 **判空**，之后再分别递归的去遍历 **左右子树的高度**，用 `-1` 来标记是否满足要求
- 最后判断左右子树的 **高度差** 是否小于 `2` 也就是不超过 `1`，如果满足就返回该高度并与 `-1` 比较即可。

### 代码

解法一：

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
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;        
    }
    
    private int recur(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 递归遍历左子树的高度
        int left = recur(node.left);
        if (left == -1) {
            return -1;
        }
        // 递归遍历右子树的高度
        int right = recur(node.right);
        if (right == -1) {
            return -1;
        }
        // 比较左右子树高度之差是否小于 2
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
```

解法二：

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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        // dfs 找左子树高度
        int leftHeight = dfs(root.left);
        // dfs 找右子树高度
        int rightHeight = dfs(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        // 如果高度差不大于 1,就递归判断其左右子树高度差是否也不大于 1
        return isBalanced(root.left) && isBalanced(root.right);
    }
    // 完完全全是 104 题的解法(求二叉树的最大深度)
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(dfs(node.left), dfs(node.right)) + 1;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/balanced-binary-tree/solution/20200408110easyzi-di-xiang-shang-di-gui-pan-duan-p/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

