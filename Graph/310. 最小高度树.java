#### [310. 最小高度树](https://leetcode-cn.com/problems/minimum-height-trees/) + 寻找最后变为叶子节点的节点

难度：Median

### 解题思路

**核心思想** ：

- 建立节点与相邻节点之间的**关系**，然后通过队列将 **叶子节点** 层层筛选出来

- 但是为了要找根节点，那就要找 **最后变成叶子节点** 的节点。

### 代码

```java
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        // 如果只有一个节点,那么他就是最小高度树
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        int[] degree = new int[n];
        // 建立图关系，在每个节点的 list 中存储相邻节点
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            // 添加相邻节点
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
            
        }
        
        Queue<Integer> queue = new LinkedList<>();
        // 将度为 1 的叶子节点入队
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            // 每层循环都要 new 一个新的结果集,最后保存的就是最终的最小高度树
            ans = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                ans.add(cur);
                // 创建邻居节点集合
                List<Integer> neighbors = map.get(cur);
                
                for (int neighbor : neighbors) {
                    // 每取出一个节点,他相邻的邻居节点的度就会减一
                    degree[neighbor]--;
                    // 当自己变成叶子节点就入队吧
                    if (degree[neighbor] == 1) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        // 返回最后一次度变为 1 的节点才是我们要找的最深层的根节点
        return ans;
    }

}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/minimum-height-trees/solution/310-zui-xiao-gao-du-shu-xun-zhao-zui-hou-bian-wei-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

