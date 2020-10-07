#### [21. 合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/) + 双解法合并两条链表

难度：Easy

### 解题思路

本题两种思路

第一种思路：

- 按照常规思路 **每次比较两条链的头结点元素** 选出较小者接到新链的头结点后面
- 最后看哪条链还有剩余元素，然后直接接到新链末尾即可。

第二种思路：

- 利用 **递归** 求解，通过第一次比较选出作为链头的结点，之后递归的元素都会接在这个头结点之后
- 最后等到遍历完了所有元素，看哪条链还有剩余元素，此时返回没有剩余元素那条链的链头即可。

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        // 最后看哪个链有剩余元素，将其接在新链后面即可
        // 也可写成 cur.next = l1 == null ? l2 : l1;
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 第一次比较，选出最小结点代表的那条链，之后递归下去一次连在后面
        // 最后哪条有剩余，就将另外一条返回
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/2020032921easy-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

