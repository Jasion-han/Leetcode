#### [124. 二叉树中的最大路径和](https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/) + DFS **递归寻找最大路径和**

难度：Hard

### 解题思路

- 这里注意定义的 `max` 数组，可换成 **全局** 变量
- 然后注意如果有 **负数值**，那么就初始化为 `0` 计算即可

- 最后递归返回的条件是 **带头结点的单边路径**，而题目要求的返回值在 **主函数内 ** 返回。

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
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 注意这里用数组存储(也可以定义为全局的 max)
        int[] max = new int[]{Integer.MIN_VALUE};
        dfs(root, max);
        return max[0];
    }
    
    private int dfs(TreeNode root, int[] max) {
        // 这里若不为 null 则寻找子树; 为了不取负值,便与 0 做了取最大值操作
        int left = root.left == null ? 0 : Math.max(dfs(root.left, max), 0);
        int right = root.right == null ? 0 : Math.max(dfs(root.right, max), 0);
        int cur = root.val + left + right;
        max[0] = Math.max(max[0], cur);
        // 递归函数定义,只能返回单边
        return root.val + Math.max(left, right);
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/solution/124-er-cha-shu-zhong-de-zui-da-lu-jing-he-dfsdi-gu/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

