#### [404. 左叶子之和](https://leetcode-cn.com/problems/sum-of-left-leaves/) + 递归寻找左孩子之和

难度：Easy

### 解题思路

本题使用递归寻找所有左孩子

- 首先 **判空**，如果找到满足题意的结点，就返回 **该结点值**，并继续遍历 **右结点**
- 其他情况就挨个递归遍历左右孩子结点，最后以 **和的形式**返回即可。

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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 如果当前节点的左孩子不为空,且下面没有结点,则返回该左孩子的值并继续遍历其右孩子
        if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        // 若没有找到就递归遍历其左孩子和右孩子
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/sum-of-left-leaves/solution/20200409404easydi-gui-xun-zhao-zuo-hai-zi-zhi-he-b/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

