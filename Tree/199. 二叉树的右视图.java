#### [199. 二叉树的右视图](https://leetcode-cn.com/problems/binary-tree-right-side-view/) + BFS 层次遍历二叉树右视图

难度：Median

### 解题思路

本题也是 `102` 题的改编题，基本思路一致，以下描述区别：

题目让遍历出一颗二叉树 **右视图** 结点元素，那么意味着在经过 **层次遍历** 后，每次将 **最后一个结点** 取出即可

这里定义接收 **目标结点** 指针 `node` ,在 `for` 循环之前 **定义为空**,而后进入循环再给它赋值为每层最后一个结点

这样 `node` 每次取出的就是一层中最后一个结点了，最后放入数组即可完成右视图遍历。

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
    public List<Integer> rightSideView(TreeNode root) {
        // 创建一维数组接收结果值
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        // 创建队列进行层次遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                // 从右往左第一个进队的元素即最右边的那个
                if (i == 0) {
                    ans.add(node.val);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                } 
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }                     
        }
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/binary-tree-right-side-view/solution/20200405199medianbfsceng-ci-bian-li-er-cha-shu-you/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

