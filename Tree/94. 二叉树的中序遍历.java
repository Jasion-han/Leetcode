#### [94. 二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/) + 中序遍历迭代法

难度：Median

### 解题思路

本题整体思路和 `144` 题先序遍历一致，具体参考 `144` 题

迭代法的中序和先序遍历的区别是先 **将当前遍历的结点和他的左孩子依次压入栈中**，此时栈顶元素是结点的左孩子

然后再将其 **弹出栈**，并放入数组中，之后再遍历右孩子

最后遍历完的顺序就是左孩子，自己，右孩子

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode p = root;
        while ( p != null || !stack.isEmpty() ) {
            // 如果非空，就将当前的结点和他的左孩子先入栈
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            // 再用 p 接收弹出栈来的左孩子
            p = stack.pop();
            // 并将其放入数组
            ans.add(p.val);
            // 再遍历他的右孩子
            p = p.right;
        }
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/2020040294medianzhong-xu-bian-li-die-dai-fa-by-jas/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

