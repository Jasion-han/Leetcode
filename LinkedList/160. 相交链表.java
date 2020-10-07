#### [160. 相交链表](https://leetcode-cn.com/problems/intersection-of-two-linked-lists/) + 回头遍历找交点

难度：Easy

### 解题思路

- a 走过的路径为 A 链 + B 链
- b 走过的路径为 B 链 + A 链

- a 和 b 走过的长度都相同，都是 A 链和 B 链的长度之和，相当于将两条链从尾端对齐

- 如果相交，则会提前在相交点相遇，如果没有相交点，则会在最后相遇。

  Q：示例 `1` 也有相同的元素 `1`,为什么交点不在 `1` 呢？
  A：因为示例  `1` 里面把相交节点前的节点数分别给定死为 `2` 和 `3` 了，我试了下改为 `1` 和 `2`，相交节点就是 `1` 了

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
        if (headA == null || headB == null) {
            return null;
        }
        
        ListNode a = headA;
        ListNode b = headB;
        
        // a:4->1->8->4->5->null->5->6->1->8->4->5->null
        // b:5->6->1->8->4->5->null->4->1->8->4->5->null
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/160-xiang-jiao-lian-biao-hui-tou-bian-li-zhao-jiao/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

