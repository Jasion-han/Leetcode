#### [328. 奇偶链表](https://leetcode-cn.com/problems/odd-even-linked-list/) + 使用两个链表暂存奇偶节点

难度：Median

### 解题思路

本题和 `82` 题思路一样都是 **创建两个空链结点** 来链接两种情况的元素，最后再合并为一条新链

- 首先对链表头结点 `head` 判空
- 然后 **创建两个空链结点** 链接题目中的 **奇数位置元素** 和 **偶数位置元素**
- 每次将 **偶数** 位置元素 **断链** 接到新的偶数链结点后面，最后再 **将奇数链最后一个结点与偶数链的头结点相连** 即可。

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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        // 标记第一个偶数位置
        ListNode evenHead = head.next;
        while (even != null && even.next != null) {
            // 1 -> 3 以此类推 ...
            odd.next = even.next;
            odd = odd.next;
            // 2 -> 4 ...
            even.next = odd.next;
            even = even.next;
        }
        // 最后一个奇数位置接上第一个偶数位置
        odd.next = evenHead;
        return head;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/odd-even-linked-list/solution/20200328328median-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

