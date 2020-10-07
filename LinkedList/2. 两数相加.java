#### [2. 两数相加](https://leetcode-cn.com/problems/add-two-numbers/) + 单链表的使用

难度：Median

### 解题思路

该问题是求两个链表各个部分之和，并建立新的链表。

主要思路是要先建立一个带头结点的新链表，等待新的数据到来。
在旧的链表上依次将相同位置的数字相加，并对 `10`取余，
如果有进位，则需要设置进位初始值为 `0`，若两数之和大于 `10`，则还要加上进位 `1`，才是最终想要得到的数据。

以此类推，如果链表最后两个数字之和还有进位，则在新链表的末尾接上进位 `1` 即可。

TimeComplexity: O(n)
SpaceComplexity: O(n)

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
---
/**
 *数学法：核心是取余数和求模*/
/**需要注意细节：*/
/**(1) l1 l2 长短不一 要记得时刻检查是否为空*/
/**（2）最后sum还剩1 要记得加上*/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 先创建一个哑结点便于操作
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int sum = 0;

        while(p1 != null || p2 != null){
            if (p1 != null){
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null){
                sum += p2.val;
                p2 = p2.next;
            }
            // 求模
            cur.next = new ListNode(sum % 10);
            // 求余数，下一次循环使用
            sum /= 10;
            cur = cur.next;
        }
        // 这里要留意[5]和[5]合并多出来 1 的情况
        if (sum == 1){
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/add-two-numbers/solution/20200305lian-biao-liang-shu-xiang-jia-by-jasion_ha/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

