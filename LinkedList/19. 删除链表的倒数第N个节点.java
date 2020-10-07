#### [19. 删除链表的倒数第N个节点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/) + 巧用移动指针

难度：Median

### 解题思路

本题巧用 **移动指针** 只需遍历一遍链表即可完成删除操作

定义两个指针 `pre` 和 `cur`，第一个指针用来 **控制下一个指针的移动距离**

当重新定位需要移动的距离后，`cur` 指针最后停下来的位置就是 **需要删除元素的前驱**，直接完成断链操作即可。

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pre = dummy;
        ListNode cur = dummy;
        // 率先走 n + 1 步，使 cur 指针最后指向要删除元素的前驱
        for (int i = 0; i < n + 1; i++) {
            pre = pre.next;
        }
        // 此时同时往后移动指针，cur 停下来的位置就是要删除元素的前驱
        while (pre != null) {
            pre = pre.next;
            cur = cur.next;
        }
        // 将 cur 后面要删除的元素断链
        cur.next = cur.next.next;
        return dummy.next;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/2020033119median-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

