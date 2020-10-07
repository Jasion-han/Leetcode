#### [112. 路径总和](https://leetcode-cn.com/problems/path-sum/) + 递归遍历路径总和是否存在

难度：Easy

### 解题思路

本题递归求解路径总和是否存在

- 首先 **判空**，然后解决 **叶子结点**，当遍历到叶子结点的时候就看 **剩下的数和自己的值是否相等**
- 其他情况就挨个遍历左子树和右子树各个结点，注意下次遍历的 `sum` 要 **减去自己的值**

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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        // 如果是叶子结点，则看该结点值是否等于剩下的 sum
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        // 每次遍历一个结点都要减去自己的值后重新递归
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/path-sum/solution/20200409112easydi-gui-bian-li-lu-jing-zong-he-shi-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

