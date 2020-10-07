#### [92. 反转链表 II](https://leetcode-cn.com/problems/reverse-linked-list-ii/) + 多指针完成链内反转

难度：Median

### 解题思路

本题使用 **三个指针** `pre`，`start`，`tail` 共同完成 **链内反转**

首先 **创建带头结点** `dummy` 连在 `head` 前面，以保证操作的统一性

然后通过对 `m` 判断将 `pre` 指针循环往后 **移动到操作位置之前**

然后通过 `start`，`tail` 指针完成 **断链 + 接链** 的过程，这样使得 **最后断的结点可以接在新链的最前面**

最后将除了带头结点 `dummy` 外的 **新链** 返回即可。

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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 创建带头结点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        // pre 移动到 m 位置的前一个
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        // 创建两个结点进行删除再连接
        ListNode start = pre.next;
        ListNode tail = start.next;
        for (int i = m; i < n; i++) {
            start.next = tail.next;
            tail.next = pre.next;
            pre.next = tail;
            // 每反转完一次再将 tail 指针重新指向 start 后面的结点
            tail = start.next;
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        // pre 移动到 m 位置的前一个
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        for (int i = m; i < n; i++) {
            // cur 和 tmp 两两反转
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            // 这里注意要先用 tmp 连上 pre.next
            tmp.next = pre.next;
            pre.next = tmp;
        }
        return dummy.next;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/2020032792median-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

