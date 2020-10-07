#### [99. 恢复二叉搜索树](https://leetcode-cn.com/problems/recover-binary-search-tree/) + 双解法寻找待交换元素

难度：Hard

### 解题思路

解法一：使用 `DFS` 寻找第一个和第二个待交换元素，然后进行交换即可。
空间复杂度 `O(n)`

解法二：使用 `Morris traversal` 搭桥拆桥法寻找待交换元素
空间复杂度 `O(1)`

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
    
    // first 指向第一个需要交换的元素
    // second 指向第二个需要交换的元素
    // 1，5，3，4，2，6
    //    ↑       ↑
    //  first   second
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode pre = null;
    
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root);
        // 交换元素值
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        // 中序遍历
        dfs(root.left);
        if (pre != null && pre.val >= root.val) {
            // 这里说明还没有找到第一个需要移动的元素
            if (first == null) {
                // 如果找到了就用 first 指向它
                first = pre;
            }
            // 如果是第二次找到，就用 second 指向交换的元素
            second = root;
        }
        pre = root;
        dfs(root.right);
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
    public void recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);
        // 标记是否第一次遇见需要交换的元素
        boolean firstTime = true;
        
        // Morris traversal
        while (root != null) {
            // 往左子树走
            if (root.left != null) {
                TreeNode temp = root.left;
                // 当右子树不为 null 并且不是 root 的时候就一直往左子树的右边走
                while (temp.right != null && temp.right != root) {
                    temp = temp.right;
                }
                // 如果是第一次走到右边尽头就要建桥,连上 root
                if (temp.right == null) {
                    temp.right = root;
                    root = root.left;
                // 已经连上 root 了说明是第二次走到右边尽头,需要拆桥
                } else {
                    temp.right = null;
                    // visit root.val
                    if (pre.val > root.val && firstTime) {
                        first = pre;
                        firstTime = false;
                    }
                    if (pre.val > root.val && !firstTime) {
                        second = root;
                    }
                    pre = root;
                    root = root.right;
                }
            // 左子树已经走到尽头了就该往右子树走
            } else {
                // visit root.val
                if (pre.val > root.val && firstTime) {
                    first = pre;
                    firstTime = false;
                }
                if (pre.val > root.val && !firstTime) {
                    second = root;
                }
                pre = root;
                root = root.right;
            }
        }
        // 最后交换两个元素即可
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/recover-binary-search-tree/solution/99-hui-fu-er-cha-sou-suo-shu-shuang-jie-fa-xun-zha/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

