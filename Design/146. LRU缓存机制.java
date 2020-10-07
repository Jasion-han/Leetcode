#### [146. LRU缓存机制](https://leetcode-cn.com/problems/lru-cache/) + 设计结构体，链表操作综合问题

难度：Median

### 解题思路

- 本题考察频率很高，需要反复练习
- 观察代码每部分的功能，理解起来也不难

### 代码

```java
class LRUCache {
    
    // 创建 Node 结构体
    class Node{
        private int key;
        private int value;
        private Node pre;
        private Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    // 创建 Map 存放节点值和该节点
    private Map<Integer, Node> map;
    // 定义 cache 中最大容量
    private int capacity;
    // 定义头尾节点指针
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        if (node != tail) {
            if (node == head) {
                head = head.next;
            // 例如要 get(2) 1<->2<->3
            //                   ↑
            } else {
                // 断链操作
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            // 接链操作
            // 1<->3<->2
            tail.next = node;
            node.pre = tail;
            node.next = null;
            tail = node;
        }
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            if (node != tail) {
                // 以下到 else 和上面 get 写法一样（把已经存在的节点更新到最新使用的位置，也就是尾部）
                if (node == head) {
                    head = head.next;
                // 例如要 get(2) 1<->2<->3
                //                   ↑
                } else {
                    // 断链操作
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }
                // 接链操作
                // 1<->3<->2
                tail.next = node;
                node.pre = tail;
                node.next = null;
                tail = node;
            }
        } else {
            // 以下是创建新的节点
            Node newNode = new Node(key, value);
            // 容量为零，就需要把头部的节点移除
            if (capacity == 0) {
                Node tmp = head;
                head = head.next;
                map.remove(tmp.key);
                capacity++;
            }
            // 如果链表为空(即新链)
            if (head == null && tail == null) {
                head = newNode;
            // 不为空，就正常接在尾部即可
            } else {
                tail.next = newNode;
                newNode.pre = tail;
                newNode.next = null;
            }
            tail = newNode;
            map.put(key, newNode);
            capacity--;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

作者：Jasion_han
链接：https://leetcode-cn.com/problems/lru-cache/solution/146-lruhuan-cun-ji-zhi-she-ji-jie-gou-ti-lian-biao/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

