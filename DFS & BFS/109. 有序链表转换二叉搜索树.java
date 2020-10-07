#### [109. 有序链表转换二叉搜索树](https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/) + 快慢指针递归建树

难度：Median

### 解题思路

- 本题和 `108` 很相似，上一题在数组中建 `BST` 树，本题在链表中建 `BST` 树
- 其主要步骤就是 **如何寻找中点**，然后 **递归** 在其两侧建立左右子树即可。

### 代码

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return dfs(head, null);
    }
    private TreeNode dfs(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        // 使用快慢指针找出中间节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow 停下来的位置就是 mid
        TreeNode root = new TreeNode(slow.val);
        // 左子树接上 mid 左边元素
        root.left = dfs(head, slow);
        // 右子树接上 mid 右边元素
        root.right = dfs(slow.next, tail);
        return root;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/solution/109-you-xu-lian-biao-zhuan-huan-er-cha-sou-suo-13/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

