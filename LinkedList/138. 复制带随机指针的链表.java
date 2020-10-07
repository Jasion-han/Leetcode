#### [138. 复制带随机指针的链表](https://leetcode-cn.com/problems/copy-list-with-random-pointer/) + 深度拷贝老节点

难度：Median

### 解题思路

- 本题和之前写过的一道 `133` **克隆图** 都要求用到 **深度拷贝**

- 深度拷贝就是创建一个 `map` 其中 `key` 部分存储老节点，`value` 部分来 `new` 新的节点
- 然后挨个将所有的老节点都 **复制** 到新的节点中来
- 具体步骤请看代码剂注释部分

### 代码

```java
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // 使用 map 来存储老节点和新节点
        Map<Node, Node> map = new HashMap<>();
        // 创建一个新的头节点
        Node cur = head;
        while (cur != null) {
            // 将老节点都复制为新的节点
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        
        cur = head;
        while (cur != null) {
            // 新节点的 next 指向老节点中对应节点的下一个，也就是复制老节点里面的后继结点到新节点中
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 返回新节点的头节点即可
        return map.get(head);
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer/solution/138-fu-zhi-dai-sui-ji-zhi-zhen-de-lian-biao-shen-d/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

