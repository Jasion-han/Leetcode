#### [24. 两两交换链表中的节点](https://leetcode-cn.com/problems/swap-nodes-in-pairs/) + 创建两个交换指针进行两两交换

难度：Median

### 解题思路

本题思路就是定义交换指针，保证交换的元素不会断链

- 在创建 `dummy` 带头结点的基础上，再 **创建三个指针** 用来完成交换元素

- 交换过程中一定要 **保证** 每个元素都 **不能断链**，每交换完一次 **记得移动指针** 便于下次交换

- 最后返回 `dummy` 结点后面元素即可。

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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        // 判断数据不为 null 才能执行
        while (cur != null && cur.next != null) {
            ListNode pNext = cur.next;
            // 交换第一批元素
            pre.next = pNext;
            cur.next = pNext.next;
            pNext.next = cur; 
            // 交换过后移动指针便于下次交换    
            pre = cur;
            cur = cur.next;
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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        
        // cur 永远指在要交换元素的前一个位置
        while (cur.next != null && cur.next.next != null) {
            // 定义第一个交换元素
            ListNode first = cur.next;
            // 定义第二个交换元素
            ListNode second = cur.next.next;
            cur.next = second;
            first.next = second.next;
            second.next = first;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs/solution/2020033024median-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

