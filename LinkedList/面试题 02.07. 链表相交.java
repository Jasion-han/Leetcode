### 解题思路

        双方分别从各自起点出发，遍历完自己的路径后再从另一头开始遍历，直到两者 【相遇】 或 【不相遇都走到了尽头】

        复杂度分析：
        时间复杂度 O(a + b) ： 最差情况下（即 |a - b| = 1 , c = 0 ），此时需遍历 a + b 个节点。
        空间复杂度 O(1) ： 节点指针 A , B 使用常数大小的额外空间。


### 代码

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            // 一开始各自沿着自己的路走，遍历完自己路径上的就转到对方的路径上，直到相遇。
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }
}
```