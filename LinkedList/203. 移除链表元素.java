#### [203. 移除链表元素](https://leetcode-cn.com/problems/remove-linked-list-elements/) + 创建带头结点统一删除节点

难度：Easy

### 解题思路

本题创建带头结点 `dummy` 可以不用单独考虑头结点的情况，统一思路的作用

定义前驱结点 `pre` 用于指向 **删除目标元素后** 的元素，防止丢链

定义当前移动结点 `cur` 来 **找目标元素** 进而将其删除

最后返回 `dummy` 结点的下一个结点即可。

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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 定义链表的前驱结点
        ListNode pre = dummy;
        // 定义 cur 依次从 head 开始遍历寻找目标元素
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next; 
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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/remove-linked-list-elements/solution/20200329203easy-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

