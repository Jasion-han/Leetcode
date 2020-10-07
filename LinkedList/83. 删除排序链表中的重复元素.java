#### [83. 删除排序链表中的重复元素](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/) + 基础链表删除重复节点算法

难度：Easy

### 解题思路

本题为基础 **删除链表中重复结点** 算法

首先为了统一性给链表 **加上带头结点**

然后 **定义移动指针** `cur` 从 `head` 结点开始依次寻找重复元素进而删除

最后将 **除了带头结点以外的新链返回** 即可。

### 代码

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 移动指针从 head 开始往后遍历
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            // 如果有重复的则直接指向重复的后继，即删除该重复结点
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;    
            } else {
                cur = cur.next;
            }            
        }
        return dummy.next;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/solution/2020032883easy-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

