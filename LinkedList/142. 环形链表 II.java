#### [142. 环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii/) +  数学思路，快慢指针

难度：Median

### 解题思路

- 本题很大程度是在考察数学运算，因为解题思想不是算法与数据结构，而是 **数学** 的思想
- 主要是画图标记每段路程，然后通过数学公式来计算求解入环的第一个节点

整体步骤就是

1. 画图找 **数学关系**
2. 使用 **快慢指针 **寻找环路

3. 根据数学关系与环路信息寻找 **入环起点**

### 代码

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        // 先使用快慢指针寻找是否有环路
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 找到相遇的点，退出 while 循环
            if (slow == fast) {
                break;
            }
        }
        // 如果上面是因为都走到了 null 退出的,说明没有环路
        if (fast == null || fast.next == null) {
            return null;
        }
        // fast 从头开始，slow 从上面相遇的位置开始同步移动,停下的位置就是入环的第一个节点
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/142-huan-xing-lian-biao-ii-shu-xue-si-lu-kuai-man-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

