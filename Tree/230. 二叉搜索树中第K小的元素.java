#### [230. 二叉搜索树中第K小的元素](https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/) + 中序递归遍历

难度：Median

### 解题思路

本题要寻找二叉搜索树第 `k` 小的元素，那么中序遍历正好是升序排列，故使用 **中序递归遍历** 整棵树

- 创建一个 `ans` 数组来存放 **中序遍历后的元素**，定义中序遍历方法体依次按照 **左中右的顺序** 遍历整棵树

- 最后遍历完所有结点，只需用 `ans` 来取出位置为 `k - 1` 的元素即为第 `k` 小的元素。

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
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        // 创建 ans 来顺序存放二叉搜索树的结点值
        List<Integer> ans = new ArrayList<>();
        inOrder(root, ans);
        // 第 k 个值就是索引 k - 1 的位置的值
        return ans.get(k - 1);
    }
    
    private void inOrder(TreeNode node, List list) {
        if (node == null) {
            return;
        }
        // 按照左中右顺序遍历
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
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
    
    private int num = 0;
    private int ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return ans;
    }
    
    private void inOrder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inOrder(root.left, k);
        num++;
        if (num == k) {
            ans = root.val;
            return;
        }
        inOrder(root.right, k);
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/solution/20200413230medianzhong-xu-di-gui-bian-li-er-cha-so/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

