#### [82. 删除排序链表中的重复元素 II](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/) + 删除重复节点基础算法

难度：Median

### 解题思路

本题就是定义了 **两个结点指针** `pre` 和 `cur` 一前一后依次遍历整个链表

-  `cur` 结点指针率先出发，如果 **没有遇见重复元素** 则两个结点指针都向后移动一个位置

- 如果 **遇见重复元素**，且 `cur.next` 不为 `null` 时，先用 `while` 循环 **将重复的结点遍历到最后**，此时 `cur` 指的就是重复元素的最后一位置

- 然后用 `pre` 结点指针指向 `cur` 的下一个位置即 **将最后一个重复元素断链**，然后继续遍历下去

- 最后返回 `dummy` 结点之后的元素即可。

### 代码

解法一：

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
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {   
            // 判断重复元素
            if (cur.next != null && cur.val == cur.next.val) {
                // 如果重复元素有多个就使用 while 循环遍历到重复元素的最后一个
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }   
                // 此时 cur 指的是重复元素的最后一个数，使用 pre 将其断链
                pre.next = cur.next;
                cur = pre.next;
            } else {
                // 没有遇到重复元素就像后继续遍历
                cur = cur.next;
                pre = pre.next;
            }                           
        }
        return dummy.next;
    }
}
```

解法二：

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
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        
        // 至少有两个元素存在
        while (cur.next != null && cur.next.next != null) {
            // 如果两元素值相同
            if (cur.next.val == cur.next.next.val) {
                // 先保存这个值
                int val = cur.next.val;
                // 只要相等就一直删除
                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/solution/2020032982median-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

