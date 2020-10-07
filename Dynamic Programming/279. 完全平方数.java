#### [279. 完全平方数](https://leetcode-cn.com/problems/perfect-squares/) + BFS，dp双解法求完全平方数

难度：Median

### 解题思路

本题使用 `BFS` 和 `dp` 来求解完全平方数

`BFS` 的方法首先用队列来暂存 **每层的元素**，用 `set` 来 **排除重复的元素**，防止每层有相同的平方数出现干扰判断

主要思想是将每层的节点依次减 `1, 4, 9...` 得到下一层元素，以此类推直到某一层出现了 `0`

此时的层数就是我们要找的 **最小个数** 的完全平方数，返回该层的 **层数** 即可。

`dp` 的方法就是要对数组进行遍历，下标为 `i` ,每次都将当前数字先更新为最大的结果

即 `dp[i] = i`，比如 `i = 4`,最坏结果为 `4 = 1 + 1 + 1 + 1` 即为 `4` 个数字

最重要的就是要求出动态转移方程：`dp[i] = MIN(dp[i], dp[i - j * j] + 1)`，`i` 表示当前数字，`j * j` 表示平方数

最后返回的 `dp[n]` 即为目标数字为 `n` 的情况下组成的完全平方数的个数。

### 代码

解法一：

```java
class Solution {
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        // 创建 set 来存放非重复的元素
        Set<Integer> visited = new HashSet<>();
        queue.add(n);
        // 定义 level 记录完全平方数的个数
        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            // 每次有元素入队就代表还有剩余子平方数
            level++;
            for (int i = 0; i < len; i++) {
                int node = queue.poll();
                // 从 1 开始取，每次拿平方数来比较
                for (int j = 1; j * j <= node; j++) {
                    // 用当前结点减去平方数 1,4,9...
                    int next = node - j * j;
                    // 找完所有的平方数即可返回
                    if (next == 0) {
                        return level;
                    }
                    // 如果 set 里面没有存放当前元素，则可以入队,入 set
                    if (!visited.contains(next)) {
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }
        }
        return 0;
    }
}
```

解法二：

```java
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        // dp 默认存放的是 0,所以从 1 开始初始化为最坏情况(没有一个完全平方数)
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }
        
        // 计算每个数字所包含的组成和的完全平方数的个数
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/perfect-squares/solution/20200405279medianbfsqiu-wan-quan-ping-fang-shu-by-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

