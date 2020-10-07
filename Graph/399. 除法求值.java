#### [399. 除法求值](https://leetcode-cn.com/problems/evaluate-division/) +  map，set构建图

难度：Median

### 解题思路

需要理解如何构图，如何递归计算值

### 代码

```java
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        
        buildGraph(map, equations, values);
        
        double[] ans = new double[queries.size()];
        // 一开始就将结果都赋值为 -1.0,后面如果有新值就更新结果
        Arrays.fill(ans, -1.0);
        
        int index = 0;
        for (List<String> q : queries) {
            String a = q.get(0);
            String b = q.get(1);
            // 如果方程中只有有一个元素本来就不存在,则跳过该计算
            if (!map.containsKey(a) || !map.containsKey(b)) {
                index++;
                continue;
            // 如果都存在,才能继续计算
            } else {
                dfs(map, a, b, ans, index, new HashSet<>(), 1.0);
                index++;
            }
        }
        return ans;
    }
    
    private void dfs(Map<String, Map<String, Double>> map, String a, String b, double[] ans, int index, Set<String> visited, double tmp) {
        // 一开始就要将元素 a 放入 visited 集合,防止重复计算
        visited.add(a);
        
        if (map.get(a).containsKey(b)) {
            ans[index] = map.get(a).get(b) * tmp;
            return;
        }
        for (String next : map.get(a).keySet()) {
            if (visited.contains(next)) {
                continue;
            }
            dfs(map, next, b, ans, index, visited, map.get(a).get(next) * tmp);
        }
    }
    
    private void buildGraph(Map<String, Map<String, Double>> map, List<List<String>> equations, double[] values) {
        int index = 0;
        // 遍历每组方程
        for (List<String> e : equations) {
            String a = e.get(0);
            String b = e.get(1);
            map.putIfAbsent(a, new HashMap<>());
            map.putIfAbsent(b, new HashMap<>());
            map.get(a).put(b, values[index]);
            map.get(b).put(a, 1.0 / values[index]);
            index++;
            map.get(a).put(a, 1.0);
            map.get(b).put(b, 1.0);
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/evaluate-division/solution/399-chu-fa-qiu-zhi-mapsetgou-jian-tu-by-jasion_han/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```