#### [100. 相同的树](https://leetcode-cn.com/problems/same-tree/) + 基础递归

难度: Easy

### 解题思路

本题利用递归思想 `DFS` 遍历每个结点是否一致

- 若**两棵树**都为空则是相同的树，若**有一方为空**则不是
- 若对应位置结点的**值不同**也不是
- 最后返回**递归判断各个结点的左右子树**即可，若子树都一样则返回 `true`，否则返回 `false`。

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        // 别忘了若有一方为空则 false
        if (p == null ||q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/same-tree/solution/20200407100easydi-gui-pan-duan-liang-ke-er-cha-shu/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

