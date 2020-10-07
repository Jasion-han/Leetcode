#### [382. 链表随机节点](https://leetcode-cn.com/problems/linked-list-random-node/) + 随机等概率访问链表节点

难度：Median

### 解题思路

- 对链表采取随机数取法，使用 `i` 来保证每次都是等概率的取出节点。

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

    // 创建头节点和随机数
    private ListNode head;
    private Random rdm;
    
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        rdm = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode tmp = head;
        int ans = tmp.val;
        int i = 1;
        while (tmp.next != null) {
            tmp = tmp.next;
            i++;
            // 让每个元素都有相同的概率
            if (rdm.nextInt(i) == 0) {
                ans = tmp.val;
            }
        }
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
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

    private ListNode head;

    private Random random = new Random();

    private List<Integer> list = new ArrayList();

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */

作者：Jasion_han
链接：https://leetcode-cn.com/problems/linked-list-random-node/solution/382-lian-biao-sui-ji-jie-dian-sui-ji-deng-gai-lu-f/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

