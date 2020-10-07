#### [23. 合并K个升序链表](https://leetcode-cn.com/problems/merge-k-sorted-lists/) + 两种思路

难度：Hard

### 解题思路

本题使用两种解法

第一种是**优先队列**：

- 利用优先队列的特性可以使多个链表每次都将**最小结点出队**，具体参考代码注释

第二种是**分治思想**：

- 只需遍历一半数组，每次将**左右两端合并**放到左端位置,之后在向中间移动,直到**到达中间位置**,然后数组减半
- 其中**合并链表**为基本思想，具体代码很好理解，剩下的着重体现在注释上。

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
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (lists == null || len == 0) {
            return null;
        }
        // 使用优先队列对链表进行排序（排序算法）
        PriorityQueue<ListNode> pq = new PriorityQueue<>(len,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) {
                    return -1;
                } else if (o1.val == o2.val) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        // 创建带头结点的新链
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        // 将原来链表的结点放入新链
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        while (!pq.isEmpty()) {
            // 头结点后面接每次出队的元素
            p.next = pq.poll();
            p = p.next;
            // 此时 p.next 指向上面出队元素的后一个结点（可参考weiwei哥图解）
            if (p.next != null) {
                pq.add(p.next);
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
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }    
        // 每次将链表的两头合并起来放到左端链表
        while(len > 1) {
            for (int i = 0; i < len / 2; i++) {
                lists[i] = mergeTwoLists(lists[i], lists[len-1-i]);
            }
            // 最后合并完后链表长度减半
            len = (len + 1) / 2;
        }
        // 最后所有的结点都会存放在最左端位置
        return lists[0];
    }
    
    // 合并两个链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        } else if (l2 != null) {
            p.next = l2;
        }
        return dummy.next;
    }
}
```

解法三：

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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        // 使用优先队列创建小顶堆
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        // 将每条链表的第一个元素入队
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                minHeap.offer(lists[i]);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!minHeap.isEmpty()) {
            // 每次都将最小元素取出接到新链表后面
            ListNode tmp = minHeap.poll();
            cur.next = tmp;
            cur = cur.next;
            if (tmp.next != null) {
                minHeap.offer(tmp.next);
            }
        }
        return dummy.next;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/2020040623hardliang-chong-si-lu-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

