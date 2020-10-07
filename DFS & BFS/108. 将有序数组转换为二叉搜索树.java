#### [108. 将有序数组转换为二叉搜索树](https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/) + 递归创建二叉搜索树

难度：Easy

### 解题思路

本题通过有序数组利用 **二分原理** 选出根节点，然后依次递归的创建其左右子树即可。

- 首先对数组 **判空**，然后定义转换方法体 `exchangeToBST` 将数组的中间值通过 **位运算** 选出来，并将其作为根节点

- 接下来就是**递归的创建其左右子树**直到遍历完整个数组
- 最后**返回根节点**即可。

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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        return exchangeToBST(nums, 0, nums.length);        
    }
    
    private TreeNode exchangeToBST(int[] nums, int left, int right) {
        if (left >= right) {
            return null;
        }
        // 这个右移不仅可以把符号位右移,同时最高位只是补零,不会对数字的大小造成影响
        int mid = (left + right) >>> 1;
        // 创建根节点为 mid 的值
        TreeNode root = new TreeNode(nums[mid]);
        // 递归创建左右子树
        root.left = exchangeToBST(nums, left, mid);
        root.right = exchangeToBST(nums, mid + 1, right);
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        TreeNode root = dfs(nums, 0, nums.length - 1);
        return root;
    }
    
    private TreeNode dfs(int[] nums, int left, int right) {
        // 这里不要忘了！防止左右重叠部分出现死循环！
        if (left > right) {
            return null;
        }
        
        int mid = left + (right - left) / 2;
        TreeNode root= new TreeNode(nums[mid]);
        // 因为之前 mid 已经成为当前的 root,所以不参与左右子树的遍历
        root.left = dfs(nums, left, mid - 1);
        root.right = dfs(nums, mid + 1, right);
        return root;
    } 
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/solution/20200413108easydi-gui-chuang-jian-er-cha-sou-suo-s/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

