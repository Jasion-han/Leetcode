#### [141. 环形链表](https://leetcode-cn.com/problems/linked-list-cycle/) + 快慢指针寻环路

难度：Easy

### 解题思路

- 本题两种解法，一种是以 **不同起点 **出发寻找环路，另一种则是以 **相同起点 **出发
- 最终如果 `fast` 指针跑出圈则构不成环路，返回 `false` 否则返回 `true`

### 代码

解法一：

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
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        // 以不同起点出发
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (slow != fast) {
            // 如果 fast 指针出圈了则说明没有形成环
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
```

解法二：

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
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        // 以相同起点出发
        ListNode slow = head;
        ListNode fast = head;
        // fast 指针不能出圈
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 如果两指针相遇说明构成了环路,返回 true 即可
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/linked-list-cycle/solution/141-huan-xing-lian-biao-kuai-man-zhi-zhen-xun-huan/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

