#### [116. 填充每个节点的下一个右侧节点指针](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/) + 保留当前层的上一层最左边节点

难度：Median

### 解题思路

- 本题是所有节点都已经填充好了
- 只需从 **最左边** 开始挨个遍历 **每层** 的节点并连接上即可

- 这里注意事先 **保留上一层的最左边节点**，这样当遍历下一层的时候可以有指针指向。

### 代码

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node cur = root;
        while (cur != null) {
            // 开始每层遍历前都保留住头节点
            Node head = cur;
            // 一层的连接步骤
            while (cur != null) {
                // 自己的左孩子连自己的右孩子
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                // 自己的右孩子连兄弟节点的左孩子
                if (cur.right != null && cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            // cur 更新到下一层的最左边节点
            cur = head.left;
        }
        return root;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/solution/116-tian-chong-mei-ge-jie-dian-de-xia-yi-ge-you-9/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

