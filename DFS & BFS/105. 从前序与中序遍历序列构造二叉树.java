#### [105. 从前序与中序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) + for循环，map取值

难度：Median

### 解题思路

两种细小区别，在于如何在 `inorder` 中找出 `root` 节点

- 第一种通过 `for` 循环遍历 `inorder` 进而找出 root 索引位置

- 第二种通过 `Map` 一开始存放 `inorder` 的每一个元素，然后通过 `get` 方法找出与 `preorder` 首个元素相等的索引

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        // 取出 preorder 的第一个元素作为 root
        TreeNode root = new TreeNode(preorder[preStart]);
        // 定义 inorder 中寻找 root 的索引指针
        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                rootIndex = i;
            }
        }
        // 两数组中分别位于 root 左子树的节点区间
        root.left = helper(preorder, inorder, preStart + 1, inStart, rootIndex - 1);
        // 两数组中分别位于 root 右子树的节点区间
        root.right = helper(preorder, inorder, preStart + 1 + rootIndex - inStart, rootIndex + 1, inEnd);
        return root;
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        // 将 inorder 中的各个元素及其索引放入 map 中
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, 0, inorder.length - 1, map);
    }
    private TreeNode helper(int[] preorder, int[] inorder, int prestart, int instart, int inend, Map<Integer, Integer> map) {
        if (prestart > preorder.length - 1 || instart > inend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[prestart]);
        // 在 map 中查找值和 preorder 首元素一样的 root 索引
        int rootindex = map.get(preorder[prestart]);
        root.left = helper(preorder, inorder, prestart + 1, instart, rootindex - 1, map);
        root.right = helper(preorder, inorder, prestart + 1 + rootindex - instart, rootindex + 1, inend, map);
        return root;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/105-cong-qian-xu-yu-zhong-xu-bian-li-xu-lie-gou-36/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

