#### [114. 二叉树展开为链表](https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/) + 栈先右后左，分治找最左和最右

难度：Median

### 解题思路

- 解法一用 **栈** 来存储，该方法耗时，不如解法二。
- 解法二用到 **分治法**，先通过 **局部结构** 进行连接，然后回到整体结构操作。

### 代码

解法一：

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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        // 用栈来存储
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            // 先将右边入栈后将左边入栈
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            // 这里不能 pop() 因为后续可能还需要该节点的孩子节点
            if (!stack.isEmpty()) {
                cur.right = stack.peek();
            }
            cur.left = null;
        }
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
    public void flatten(TreeNode root) {
        dfs(root);
    }
    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 保留最左边和最右边
        TreeNode leftLast = dfs(root.left);
        TreeNode rightLast = dfs(root.right);
        if (leftLast != null) {
            // 右边接到左边的右边
            leftLast.right = root.right;
            // 左边接到 root 的右边
            root.right = root.left;
            // root 的左边变成 null
            root.left = null;
        }
        
        // 保留一个节点用于下次的衔接
        if (rightLast != null) {
            return rightLast;
        }
        if (leftLast != null) {
            return leftLast;
        }
        return root;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/solution/114-er-cha-shu-zhan-kai-wei-lian-biao-zhan-xian-yo/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

