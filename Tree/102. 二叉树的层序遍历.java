#### [102. 二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/) + BFS 和 DFS 双解法

难度：Median

### 解题思路

本题要求层次遍历每层结点并放入一个二维数组中

首先就创建一个 **二维数组** 用来接收最后的结果，同时做 **判空** 操作

接下来就是层次遍历用到的典型的 **队列**，队列中每次只存放 **一层的结点** ，然后创建一个 **一维数组** 用来接收队列中 **每次存放的元素**

然后如果有左右孩子就将他们也 **入队再放入数组** 中，然后一维数组再放入二维数组中

等到遍历完所有的结点，返回 `ans` 即可。

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 创建二维数组接收每层的结点
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        // 创建队列依次存放每层的结点
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            // 创建数组来接收出队的结点，存放的是每层的结点
            List<Integer> tmp = new ArrayList<>();
            int len = q.size();
            for (int i = 0; i < len; i++) {
                // 定义 node 接收出队结点，然后加入数组 tmp 中
                TreeNode node = q.poll();
                tmp.add(node.val);
                // 如果有左右孩子，就依次入队、出队、进数组
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            // 数组每次都是放的一层的结点，然后一层一层的放入二维数组中
            ans.add(tmp);
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        // DFS 进行层序遍历
        dfs(root, ans, 0);
        return ans;
    }
    
    private void dfs(TreeNode root, List<List<Integer>> ans, int depth) {
        if (root == null) {
            return;
        }
        // 该深度下节点个数达到饱和则放入新的 ArrayList
        if (depth >= ans.size()) {
            ans.add(new ArrayList<>());
        }
        // 根据不同的深度存放相应数量的节点值
        ans.get(depth).add(root.val);
        // 递归调用左右孩子
        dfs(root.left, ans, depth + 1);
        dfs(root.right, ans, depth + 1);
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/20200404102medianbfsceng-ci-bian-li-by-jasion_han-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

