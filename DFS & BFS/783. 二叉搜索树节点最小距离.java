#### [783. 二叉搜索树节点最小距离](https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/) + 中序递归遍历二叉搜索树

难度：Easy

### 解题思路

本题根据题目意思可知给定的是一颗 **二叉搜索树**，我们可以使用 **中序 **遍历从最小的值开始依次比较最小差值

- 一开始我们定义一个全局变量 pre 来保存当前结点的 **上一个相邻结点**，用于每次和当前的结点进行比较
- 然后初始化 `min` 来贪心的比较最小值
- 之后定义一个 **中序的递归方法体**，遍历顺序依次为 **左，中，右**
- 其中遍历到 **中间结点 **的时候，如果不为空就每次 **更新结点 **指针进行比较
- 最后用 `ans`接收比较出来的最小值 `min`,返回即可。

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
    
    // 定义 pre 来保存上一个结点值
    Integer pre;
    int min = Integer.MAX_VALUE;
    
    public int minDiffInBST(TreeNode root) {        
        int ans = dfs(root);
        return ans;
    }
    
    private int dfs(TreeNode node) {        
        if (node == null) {
            return 0;
        } 
        // 先从左开始
        dfs(node.left); 
        // 然后中间
        if (pre != null) {
            min = Math.min(min, node.val - pre);
        }
        pre = node.val;
        // 最后右边
        dfs(node.right);
        return min;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/solution/20200411783easyzhong-xu-di-gui-bian-li-er-cha-sou-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。	
```

