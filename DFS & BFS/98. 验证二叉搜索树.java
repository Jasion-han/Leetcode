#### [98. 验证二叉搜索树](https://leetcode-cn.com/problems/validate-binary-search-tree/) + 中序递归验证二叉搜索树

难度：Median

### 解题思路

本题是使用 **递归 **的方法 **中序遍历 **验证是否是二叉搜索树

- **中序遍历规则 **首先是遍历二叉树的左子树，如果其左子树不合法则返回 `false`，否则继续遍历其根节点
- 因为首先传进来的是个空 `p`，则需要跳过根节点的判断，先将 `p` 指向 `root`，随后 **递归遍历右子树**
- 那么每次 `p` 所指结点都是遍历 **右子树之前的那个根节点**，所以需要 **严格小于下一轮的根节点** `root` ，否则返回 `false`
- 最后遍历完所有结点如果 **没有遇到不满足 **的就返回 `true` 即可。

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
    TreeNode p = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 如果左子树不合法
        if (!isValidBST(root.left)) {
            return false;
        }
        // 如果 p 所指结点值大于等于下一轮的根节点
        if (p != null && p.val >= root.val) {
            return false;
        }
        // p 指向上一轮的根节点
        p = root;
        // 递归遍历右子树
        return isValidBST(root.right);
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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    // 这里因为最小值最大值可能超出 int 类型,所以换用 long 类型存储
    private boolean dfs(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        // 如果不合法则返回 false
        if (root.val <= min || root.val >= max) {
            return false;
        }
        // 比较其左子树与右子树是否都满足二叉搜索树
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/validate-binary-search-tree/solution/2020041198medianzhong-xu-di-gui-yan-zheng-er-cha-s/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

