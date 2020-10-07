#### [101. 对称二叉树](https://leetcode-cn.com/problems/symmetric-tree/) + 两种方法判断二叉树是否对称

难度：Easy

### 解题思路

本题给出两种方法判断二叉树是否对称

第一种方法是 **递归**：

- 从根节点开始递归调用 **左右子树结点**，然后通过判断其左右子树的 **左边是否等于右边** 得出结论。

第二种方法是 **迭代**：

- 通过创建 **队列** 来存放 **对称的结点** 元素，进而再判断是否一致即可，最后注意一下代码注释处的内容。

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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 递归调用判断左右子树
        return isSameTree(root.left, root.right);        
    }
    
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        // 判断左右子树的左边是否等于右边
        return isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 使用队列来存放结点元素
        Queue<TreeNode> queue = new LinkedList<>();
        // 先将根节点的左右节点入队
        queue.add(root.left);
        queue.add(root.right);
        while (queue.size() > 0) {
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();
            // 这里一定要 continue，不是 return true
            // 因为可能只是到达了某个叶子结点，接下来还要再继续遍历其他分支
            if (p == null && q == null) {
                continue;
            }
            if (p == null || q == null) {
                return false;
            }
            if (p.val != q.val) {
                return false;
            }
            // 这里一定要左右对称着入队
            queue.add(p.left);
            queue.add(q.right);
            queue.add(p.right);
            queue.add(q.left);
        }
        return true;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/symmetric-tree/solution/20200408101easyliang-chong-fang-fa-pan-duan-er-cha/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

