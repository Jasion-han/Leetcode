#### [133. 克隆图](https://leetcode-cn.com/problems/clone-graph/) + DFS深拷贝节点

难度：Median

### 解题思路

- 本题按照 **深拷贝** 的方法首先使用 `map` 构建新的节点，但并 **不构建邻居节点**
- 等到后面再一一搭建邻居节点，这样就完成了深拷贝图的过程。

### 代码

解法一：

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        Map<Node, Node> map = new HashMap<>();
        // 深拷贝 node 的值放入 map
        copyNode(node, map);
        // 再将其邻居也放入
        copyNei(node, map, new HashSet<Node>());
        
        return map.get(node);
    }
    
    private void copyNode(Node node, Map<Node, Node> map) {
        if (map.containsKey(node)) {
            return;
        }
        // 先存放新的 list 等到遍历完邻居再补充到里面
        map.put(node, new Node(node.val, new ArrayList<>()));
        for (Node nei : node.neighbors) {
            copyNode(nei, map);
        }
    }
    
    private void copyNei(Node node, Map<Node, Node> map, HashSet<Node> visited) {
        // 排除重复遍历的邻居
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);
        for (Node nei : node.neighbors) {
            // 新的节点加上新的邻居(get 出来的是存放的新节点)
            map.get(node).neighbors.add(map.get(nei));
            // 递归遍历其他邻居(邻居可能有多个也可能没有)
            copyNei(nei, map, visited);
        }
    }
}
```



解法二：

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    private Node dfs(Node node, Map<Node, Node> map) {
        if (node == null) {
            return null;
        }
        // 如果 map 中已经包含了该节点，直接返回新的节点即可
        if (map.containsKey(node)) {
            return map.get(node);
        }
        // 创建克隆新节点
        Node mirror = new Node(node.val, new ArrayList<>());
        map.put(node, mirror);
        for (Node nei : node.neighbors) {
            // 将新节点连上新的邻居(邻居可能有多个，需要递归寻找)
            map.get(node).neighbors.add(dfs(nei, map));
        }
        return mirror;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/clone-graph/solution/133-ke-long-tu-dfsshen-kao-bei-jie-dian-by-jasion_/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

