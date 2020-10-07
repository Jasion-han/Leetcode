#### [210. 课程表 II](https://leetcode-cn.com/problems/course-schedule-ii/) + 入度数组，结果数组

难度：Median

### 解题思路

- 本题和 **课程表Ⅰ** 很相似，具体差别就在于定义的 `k` 不断遍历将先修课存放到结果数组 `ans` 中

### 代码

```java
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        // 定义最终课程顺序的结果数组
        int[] ans = new int[numCourses];
        int k = 0;
        
        for (int[] pair : prerequisites) {
            inDegree[pair[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
                // 按照顺序将先修课放入最终结果数组中
                ans[k++] = i;
            }
        }
        while (!q.isEmpty()) {
            int pre = q.poll();
            for (int[] pair : prerequisites) {
                // 每遇到先修课,就将需要这门先修课的课程入度减一
                if (pair[1] == pre) {
                    inDegree[pair[0]]--;
                    if (inDegree[pair[0]] == 0) {
                        q.offer(pair[0]);
                        // 将新变为先修课的课程放入结果数组中
                        ans[k++] = pair[0];
                    }
                }
            }
        }
        // 最后判断 ans 数组中是否已经将所有课程都存放进去了
        return k == numCourses ? ans : new int[0];
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/course-schedule-ii/solution/210-ke-cheng-biao-ii-ru-du-shu-zu-jie-guo-shu-zu-b/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

