#### [117. 填充每个节点的下一个右侧节点指针 II](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/) + 头指针，移动指针，层级指针

难度：Median

### 解题思路

- 本题用到 **多个指针** 巧妙的完成每层节点的连接工作
- 尽管这题不像上一题说的每个节点都是填充好了的，但创建 **头指针** 和 **移动指针** 也可完成操作

- 具体每层的连接步骤在 **第二个** `while` 循环内完成

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
        // 定义 head 永远指向每层的最左边元素不动
        // pre 从当前层最左边开始不断向右遍历进行节点间的连接
        Node head = null;
        Node pre = null;
        // 定义 cur 从 root 开始遍历
        Node cur = root;
        
        while (cur != null) {
            // 每层的循环
            while (cur != null) {
                if (cur.left != null) {
                    // 左孩子还没访问就让 head 和 pre 分别指向最左边
                    if (head == null) {
                        head = cur.left;
                        pre = cur.left;
                    // 之后的连接工作只让 pre 自己移动
                    } else {
                        pre.next = cur.left;
                        pre = pre.next;
                    }
                }
                if (cur.right != null) {
                    // 右孩子还没访问就让 head 和 pre 分别指向最右边
                    if (head == null) {
                        head = cur.right;
                        pre = cur.right;
                    // 之后的连接工作只让 pre 自己移动
                    } else {
                        pre.next = cur.right;
                        pre = pre.next;
                    }
                }
                cur = cur.next;
            }
            // cur 指向下一层的最左边节点
            cur = head;
            head = null;
            pre = null;
        }
        return root;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/solution/117-tian-chong-mei-ge-jie-dian-de-xia-yi-ge-you-8/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

