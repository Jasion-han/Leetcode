#### [237. 删除链表中的节点](https://leetcode-cn.com/problems/delete-node-in-a-linked-list/) + 后继结点覆盖要删节点

难度：Easy

### 解题思路

本题在 **不给头结点** 的情况下删除重复的元素

- 按照题目要求先确保不是尾结点
- 然后用 **后继结点的值** 覆盖掉要删除元素的值，最后再 **将重复元素断链** 即达到了删除重复结点的方法

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
    public void deleteNode(ListNode node) {
        // 如果为 null 则抛出异常, 确保了 node 不是尾节点
        if (node == null || node.next == null) {
            throw new IllegalArgumentException("node should be valid and can not be the tail node");    
        }   
        // 将 node 后面结点的值覆盖掉 node 的值
        node.val = node.next.val;
        // 再将重复的那个结点断链即可。
        node.next = node.next.next;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/delete-node-in-a-linked-list/solution/20200331237easy-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

