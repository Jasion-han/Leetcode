#### [653. 两数之和 IV - 输入 BST](https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/) + 巧用 Hashset 查找缺少的值

难度：Easy

### 解题思路

- 本题使用 `Hashset` 将目标元素进行筛选，最终返回查找结果即可。

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
    public boolean findTarget(TreeNode root, int k) {
        // 使用 Hashset 来存储每个元素
        Set<Integer> set = new HashSet<>();
        return find(root, k, set);
    }
    
    public boolean find(TreeNode node, int k, Set<Integer> set) {
        if (node == null) {
            return false;
        }
        // 如果 Set 中有对应缺少的值，则查找成功
        if (set.contains(k - node.val)) {
            return true;
        }
        set.add(node.val);
        // 如果当前节点没找到，就依次遍历其左右结点
        return find(node.left, k, set) || find(node.right, k, set);
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/solution/653-qiao-yong-hashsetcha-zhao-que-shao-de-zhi-by-j/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

