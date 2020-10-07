#### [106. 从中序与后序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/) +  map取值

难度：Median

### 解题思路

- 通过 `Map` 一开始存放 `inorder` 的每一个元素
- 然后通过 `get` 方法找出与 `postorder` 最后一个元素相等的索引作为 `root` 的索引

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        // 先将 inorder 中每个元素及其索引放入 map 中
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, map);
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int poStart, int poEnd, Map<Integer, Integer> map) {
        if (poStart < 0 || inStart > inEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[poEnd]);
        // 在 map 中查找值为 postorder 的首元素在 inorder 中的索引作为 rootIndex
        int rootIndex = map.get(postorder[poEnd]);
        // 两数组中分别位于 root 左子树的节点区间
        root.left = helper(inorder, postorder, inStart, rootIndex - 1, poStart, poStart + rootIndex - inStart - 1, map);
        // 两数组中分别位于 root 右子树的节点区间
        root.right = helper(inorder, postorder, rootIndex + 1, inEnd, poStart + rootIndex - inStart, poEnd - 1, map);
        return root;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solution/106-cong-zhong-xu-yu-hou-xu-bian-li-xu-lie-gou--12/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

