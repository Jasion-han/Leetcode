#### [234. 回文链表](https://leetcode-cn.com/problems/palindrome-linked-list/) + 快慢指针

难度：Easy

### 解题思路

本题思路和 `143` 题很相似，区别就在于本题的最后会 **比较两段链表的值是否相等** 也就是判断是不是回文

- `143` 题找链表的中间位置是先求出 **链表长度** 再从头移动一半的长度，而本题使用了 **快慢指针** 寻找更加方便

- 其他操作比如断链，逆序都是一样的

- **不同** 就在于逆序后的链表需要和前一半的链表元素值挨个 **比较看是否相等**

- 无论链表元素是 **奇数个还是偶数个**，如果在比较过程中有不相等的直接就返回 `false`

- **若有一方遍历结束** 还没返回 `false` 则证明两部分元素值是一样的，返回 `true` 即可。

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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 定义快慢指针
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 此时 tmp 指向了后半段的第一个元素
        // 例如：1->2->2->1
        //           tmp
        ListNode tmp = slow.next;
        // 这句断链操作不写也能AC
        slow.next = null;
        
        // 将后半段链表反转
        ListNode newHead = reverse(tmp);
        
        // 比较前后两段链表是否一样
        while (head != null && newHead != null) {
            if (head.val != newHead.val) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }
    
    // 最基本的反转链表操作
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
链接：https://leetcode-cn.com/problems/palindrome-linked-list/solution/20200401234easykuai-man-zhi-zhen-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

