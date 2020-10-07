#### [437. 路径总和 III](https://leetcode-cn.com/problems/path-sum-iii/) + 递归求解路径数

难度：Median

### 解题思路

本题递归求解目标路径数

- 通过递归 **先从根节点出发 **求解目标路径数，然后在 **递归遍历其左右子树 **下的路径数
- 创建递归方法体，定义 `ans` 来累加满足要求的路径数，每次都需要用 **剩余的值减去当前结点的值 **更新整数 `sum`
- 最后返回累加的结果 `ans` 即可。

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
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        // 在以root为根节点的二叉树中,寻找和为sum的路径,返回这样的路径个数
        // 之后再递归遍历左右子树
        return findPath(root, sum) 
            + pathSum(root.left, sum) 
            + pathSum(root.right, sum); 
    }
    
    // 在以node为根节点的二叉树中,寻找包含node的路径,和为sum
    private int findPath(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        
        int ans = 0;
        if (node.val == sum) {
            ans += 1;
        }
        // 递归遍历左右子树满足要求的路径数累加到 ans 中
        ans += findPath(node.left, sum - node.val);
        ans += findPath(node.right, sum - node.val);
        return ans;
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
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        // 因为可以从任意节点作为起始位置，所以后面要加上递归以其他节点作为起始位置的情况
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    private int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum -= root.val;
        // 如果 sum 等于 0 说明找到一条路径，接着再递归寻找剩余所需节点值
        return (sum == 0 ? 1 : 0) + dfs(root.left, sum) + dfs(root.right, sum);
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/path-sum-iii/solution/20200410437easydi-gui-qiu-jie-lu-jing-shu-by-jasio/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

