#### [25. K 个一组翻转链表](https://leetcode-cn.com/problems/reverse-nodes-in-k-group/) + 根据图示理解

难度：Hard

### 解题思路

题目要求：**你的算法只能使用常数的额外空间**

- 这句话告知我们不能使用递归思路去求解，只能用不断迭代的思想慢慢遍历链表。

做题之前先自己画个图想想大致思路，理清每一个临界位置的指向

- 首先通过 `k` 次 `for` 循环用 `end` 指针指向 **翻转元素的末尾**

- 此时判断一下如果翻转元素不到 `k` 个，即 `end == null` ，说明已经到达末尾，直接返回即可

- 接下来需要定义两个指针 `pre` 和 `pLast` 分别记录 **翻转元素的前驱和后继**，以便将翻转元素前后两部分连接起来

- 之后再重置 `pre` 和 `end` 指针，进入下一次循环

- 遍历完之后返回 `dummy` 带头结点接下来的元素即可。

[PS：图片转载自"王小二"---图解k个一组翻转链表](https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/tu-jie-kge-yi-zu-fan-zhuan-lian-biao-by-user7208t/)

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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end != null) {
            // 让 end 遍历到需要翻转的最后一个元素位置
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;                    
            }
            // 只要 end 遍历到了 null 直接跳出循环
            if (end == null) {
                break;
            }
            // 定义 pLast 指向翻转元素后面第一个元素
            ListNode pLast = end.next;
            // 定义 start 指向翻转元素的第一个位置
            ListNode start = pre.next; 
            // 最后一个翻转元素先断链
            end.next = null;
            // 然后通过翻转方法 reverse() 后接在 pre 后面
            pre.next = reverse(start);
            
            // 保持下次循环一致的位置
            start.next = pLast;
            pre = start;
            end = pre;           
        }
        return dummy.next;
    }
    
    // 链表逆转模版
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode p = cur.next;
            cur.next = pre;
            pre = cur;
            cur = p;            
        }
        return pre;
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        int cnt = 0;
        while (cur != null && cnt != k) {
            cur = cur.next;
            cnt++;
        }
        if (cnt == k) {
            cur = reverseKGroup(cur, k);
            while (cnt > 0) {
                // 反转 k 个元素
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
                cnt--;
            }
            // head 指向反转后的头部,也就是 cur 所指位置
            head = cur;
        }
        return head;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/2020033025hard-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

