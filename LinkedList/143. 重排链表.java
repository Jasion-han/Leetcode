#### [143. 重排链表](https://leetcode-cn.com/problems/reorder-list/) + 找中点，逆序，再插入

难度：Median

### 解题思路

本题整体思路还是很清晰的，就是 **将链表拆分成两部分，后一半逆序** 后插入到前一半中即可

具体步骤如下:

- 首先对链表 **判空**，给程序一个出口

- 若链表 **不为空**，首先 **计算链表长度**，定义 `tmp` 移动到链表中间位置，用一个指针 `tail` 保存链表后一半并断链

- （另解）上一步也可不用计算长度，直接用 **快慢指针**  `slow` 和 `fast` 进行移动，`slow` 一步一步走， `fast` 一次走两步，遍历完后，`slow` 刚好位于链表中间

- 找到中间位置后，将后一半链表 **逆序**

- 逆序完的链表 **交替插入** 前半部分的链表 **间隔** 中即可

- 因题目中是 `void` 类型，所以最后 **不用返回** 链表结点了。

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
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // 前半段链表的头节点
        ListNode l1 = head;
        // 使用快慢指针法找整个链表的中点
        ListNode mid = findMid(head);
        // 后半段链表的头节点
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverse(l2);
        // 将后半段反转后的链表间接插入到前半段链表中
        while (l1 != null && l2 != null) {
            ListNode tmp = l1.next;
            l1.next = l2;
            l2 = l2.next;
            l1.next.next = tmp;
            l1 = tmp;
        }
    }
    
    // 快慢指针找中点
    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    // 反转链表基本操作
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/reorder-list/solution/20200401143median-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

