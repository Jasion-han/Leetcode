#### [337. 打家劫舍 III](https://leetcode-cn.com/problems/house-robber-iii/) +  DFS，DP

难度：Median

### 解题思路

本题是 `dp` 和树 **递归** 的结合题

- 每个节点可选择 **偷** 或者 **不偷** 两种状态，根据题目意思，相连节点不能一起偷

  当前节点选择偷时，那么两个孩子节点就不能选择偷了
  当前节点选择不偷时，两个孩子节点只需要拿最多的钱出来就行(两个孩子节点偷不偷没关系)
  我们使用一个大小为 `2` 的数组来表示 `int[] ans = new int[]{noRob, rob}` `0` 代表不偷，`1` 代表偷

- 任何一个节点能偷到的最大钱的状态可以定义为

  当前节点选择不偷：当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
  当前节点选择偷：当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数

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
    public int rob(TreeNode root) {
        int[] ans = dfs(root);
        // ans[0] 表示不抢 root 的话，得到的最大钱数
        // ans[1] 表示抢 root 的话，得到的最大钱数
        return Math.max(ans[0], ans[1]);
    }
    
    private int[] dfs(TreeNode root) {
        int[] ans = new int[2];
        if (root == null) {
            return ans;
        }
        
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        // 抢的话,其左右孩子就不能抢了
        ans[1] = root.val + left[0] + right[0];
        // 不抢的话,就比较其左右孩子抢与不抢带来的收益大小做决定
        ans[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/house-robber-iii/solution/337-da-jia-jie-she-iii-dfsdp-by-jasion_han/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

