#### [103. 二叉树的锯齿形层次遍历](https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/) + BFS 锯齿形层次遍历

难度：Median

### 解题思路

本题和 `102` 题很相似，区别就在于判断当前层数的奇偶性，以下描述区别：

首先定义 `cnt` 来记录 **层数的奇偶性**，然后在每层结点出队时判断一下该层的奇偶性再存入数组

如果是 **偶数层** 就 **正向** 存储（以 `0` 为起始层），**奇数层** 则 **反向** 存储

每次存储到数组后 `cnt++`，再将数组放入接收结果的二维数组 `ans`，最后返回 `ans` 即可

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        // 记录层数的奇偶性
        int cnt = 0;
        while (!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();            
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll(); 
                // 这里将层数的奇偶性做下判断
                // 如果是偶数层就正向存储（以 0 为起始层）
                if (cnt % 2 == 0) {
                    tmp.add(node.val);
                } else {
                    // 奇数层则反向存储
                    tmp.add(0, node.val);
                }
                
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            cnt++;
            ans.add(tmp);
        }
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/solution/20200404103medianbfsju-chi-xing-ceng-ci-bian-li-by/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

