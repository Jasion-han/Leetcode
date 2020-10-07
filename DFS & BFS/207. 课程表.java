#### [207. 课程表](https://leetcode-cn.com/problems/course-schedule/) + BFS, 入度表

难度：Median

### 解题思路

- 本题使用 `BFS` + **入度表** 进行拓扑排序，主要思想是：
- 先构造 **邻接表** 和节点 **入度数组** ，并建立先修课与需要先修课的课程之间的 **映射关系**
- 将入度为 `0` 的节点入队(即先修课)，通过判断需要先修课的课程在入度表中的值是否能降为 `0` 进而当作新的先修课入队，直到遍历完所有课程

- 最后将课程数目是否都被修完作为结果进行返回

### 代码

解法一：

```java
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 创建入度数组
        int[] inDegree = new int[numCourses];
        int ans = numCourses;
        
        // 遍历二维数组,将每个一维数组里面第一个元素放入入度数组为了检查该门课有多少先修课程
        for (int[] pair : prerequisites) {
            // pair[0] 是几,在 inDegree 数组中的索引就是几
            inDegree[pair[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < inDegree.length; i++) {
            // 如果有哪个索引值为 0 说明该课程没有先修课,入队
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        
        while (!q.isEmpty()) {
            int pre = q.poll();
            ans--;
            for (int[] pair : prerequisites) {
                // 再次扫描所有课程,如果已经是先修课就可以跳过
                if (inDegree[pair[0]] == 0) {
                    continue;
                }
                // 取出先修课后,则原先需要先修课的课程入度就减一
                if (pair[1] == pre) {
                    inDegree[pair[0]]--;
                }
                // 当入度变为 0 之后,自己就可以作为先修课继续遍历
                if (inDegree[pair[0]] == 0) {
                    q.offer(pair[0]);
                }
            }
        }
        
        return ans == 0;
    }
}
```

解法二：

```java
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        // 创建邻接表
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
            
        for(int[] pair : prerequisites) {
            indegrees[pair[0]]++;
            // 建立先修课与需要先修课的课程之间的邻接关系
            adjacency.get(pair[1]).add(pair[0]);
        }
        
        // 将入度为 0 的课程(也就是先修课)入队
        for(int i = 0; i < numCourses; i++) {
            if(indegrees[i] == 0) {
                queue.add(i);
            } 
        }
            
        // BFS + 拓扑排序
        while(!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            // 取出需要先修课的课程
            for(int cur : adjacency.get(pre)) {
                // 该课程入度减一后如果入度为 0 即可变成其他课程的先修课入队
                if(--indegrees[cur] == 0) {
                    queue.add(cur);
                } 
            }
        }
        // 最终返回总课程有没有全部修完即可
        return numCourses == 0;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/course-schedule/solution/207-ke-cheng-biao-bfsru-du-biao-by-jasion_han/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

