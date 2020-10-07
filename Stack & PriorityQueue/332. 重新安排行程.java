#### [332. 重新安排行程](https://leetcode-cn.com/problems/reconstruct-itinerary/) + 建图，逆序插入，不断回退试探

难度：Median

### 解题思路

如题

### 代码

```java
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // 因为逆序插入,所以用链表
        List<String> ans = new LinkedList();
        if (tickets == null || tickets.size() == 0) {
            return ans;
        }
        // 构造邻接表
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for (List<String> ticket : tickets) {
            
            PriorityQueue<String> edge = map.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>());
            edge.offer(ticket.get(1));
        }

        dfs(map, "JFK", ans);
        return ans;
    }
    
    // DFS遍历图，当走到不能走为止，再将节点加入到答案
    private void dfs(Map<String, PriorityQueue<String>> map, String start, List<String> ans) {
        PriorityQueue<String> pq = map.get(start);
        while (pq != null && pq.size() > 0) {
            // 需要有序地出队
            String cur = pq.poll();
            dfs(map, cur, ans);
        }
        // 在头部插入, 0 代表第一个索引位置
        ans.add(0, start);
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/reconstruct-itinerary/solution/332-zhong-xin-an-pai-xing-cheng-jian-tu-ni-xu-cha-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

