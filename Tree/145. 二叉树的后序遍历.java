#### [145. 二叉树的后序遍历](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/) + 后序遍历迭代法

难度：Median

### 解题思路

本题和 `144` 题先序遍历有很相似的地方，只要将那道题中解法一的 **顺序** 改变一下即可。
而这里用到了另一种的迭代方法，很考验逻辑能力

这里多定义了一个 `last` 指针，为了记录 **上次遍历的结点** 所在分支

首先 **结点自己和左孩子** 是需要先入栈等待

如果有右孩子就遍历右孩子，如果没有则 **出栈** 栈顶元素，并回退到上一个结点

如果已经遍历过右孩子，则说明 **右子树也被遍历过**，只需将其出栈并放入数组即可

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode node = root;
        //定义 last 记住上次遍历的节点
        TreeNode last = null;
        while ( node != null || !stack.isEmpty() ) {
            // 挨个把当前结点和其左孩子入栈
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            // node 指向栈顶元素但不出栈
            node = stack.peek();
            // 如果此时栈顶元素没有右孩子或者已经遍历过右孩子所在的右子树
            if (node.right == null || node.right == last) {
                // 就将此时的栈顶元素放入数组
                ans.add(node.val);
                // 并出栈
                stack.pop();
                last = node;
                node = null;
            } else {
                // 有右孩子就遍历其右孩子
                node = node.right;
            }
        }
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
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        // 使用链表来存储
        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            // 每次新的节点都放入第一个位置，而不是接在后面
            ans.addFirst(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal/solution/20200402145hardhou-xu-bian-li-die-dai-fa-by-jasion/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

