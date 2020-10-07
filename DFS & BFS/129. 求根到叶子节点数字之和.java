#### [129. 求根到叶子节点数字之和](https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/) + 递归求解 “根 -> 叶子“ 数字之和

难度：Median

### 解题思路

本题使用 **递归 **的方法DFS **深度优先遍历 **每个结点值，再求和

- 首先定义一个变量 `ans` 来 **接收递归后的结果**
- 然后定义 **递归方法体** `dfs`,先对传进来的结点值进行 **判空**，若不为空则定义 `sum` 来 **累加 **所有结点的值
- 因为累加规则是在递归 **遍历前 **就先更新了值，所有当遍历到 **叶子结点 **的时候，直接返回 `sum` 即可
- 若还没有遍历到叶子结点就依次递归遍历 **左右子树 **的结点值
- 所有结点 **遍历完后 **将结果传给 `ans` ，随后返回即可。

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
    public int sumNumbers(TreeNode root) {        
        // 定义 ans 来接收计算的结果
        int ans = dfs(root, 0);
        return ans;
    }
    
    private int dfs(TreeNode root, int num) {
        if (root == null) {
            return 0;
        }
        // 每次将之前求出来的数先 * 10再加上当前结点值
        int sum = num * 10 + root.val;
        // 如果只有根节点或者到了叶子结点直接返回当前计算出来的值即可
        if (root.left== null && root.right == null) {
            return sum;
        }
        return dfs(root.left, sum) + dfs(root.right, sum);
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
    
    int ans = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return ans;
        }
        dfs(root, 0);
        return ans;
    }
    private void dfs(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            ans += val * 10 + root.val;
            return;
        }
        dfs(root.left, val * 10 + root.val);
        dfs(root.right, val * 10 + root.val);
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/solution/20200410129mediandi-gui-qiu-jie-gen-xie-zi-shu-zi-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

