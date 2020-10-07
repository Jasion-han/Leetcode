#### [530. 二叉搜索树的最小绝对差](https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/) + 递归求解

难度：Easy

### 解题思路

本题利用二叉搜索树的 **中序遍历 **将元素排好序后进行 **逐个比较差值**

- 首先对根节点 **判空**，然后 **中序的遍历 **二叉搜索树
- 按照 **左中右 **的顺序将元素按升序排好序后，用 `pre` 和 `node` **逐个比较相邻结点 **之间的绝对差值
- 最后比较完后选出 **最小绝对差值 **传入 `ans` 并返回

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
    
    // 定义 pre 来指向当前结点的前一个相邻结点
    TreeNode pre = null;
    int ans = Integer.MAX_VALUE;
    
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 中序遍历二叉搜索树
        inOrder(root);
        return ans;
    }
    
    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        // 按照左中右的顺序排好序后挨个比较差值选出最小值传入 ans
        inOrder(node.left);
        if (pre != null) {
            ans = Math.min(ans, Math.abs(node.val - pre.val));
        }
        pre = node;
        inOrder(node.right);
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/solution/20200414530easydi-gui-qiu-jie-er-cha-sou-suo-shu-d/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

