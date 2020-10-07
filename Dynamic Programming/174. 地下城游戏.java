#### [174. 地下城游戏](https://leetcode-cn.com/problems/dungeon-game/) + 两路寻找较小者往回遍历

难度：Hard

### 解题思路

- 本题首先将 `dp` 数组初始化为最大值，目的是到最后可以看出哪些位置发生了 **变更**
- 然后我们从 `dp` 数组多的那一行和那一列的 **最后位置** 往回遍历寻找最小的路径

- 注意血量低于 `1` 要按最低为 `1` 计算，否则是多少就按多少计算
- 最后返回起点位置即为最低所需生命值

### 代码

```java
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int m = dungeon.length;
        int n = dungeon[0].length;
        // 在 i j 位置所需最小的生命值
        int[][] dp = new int[m + 1][n + 1];
        // 先将 dp 数组设为最大值，那么到最后遍历过的位置就会变为真正小的值
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        // 把 dp 数组里面最后一行的最后一个位置和最后一列的最后一个位置设为 1,这样方便往回算
        dp[m - 1][n] = 1;
        dp[m][n - 1] = 1;
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // 找出两条路线中最小的位置
                int minHp = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                // 如果生命值小于 1 就按最低为 1 计算，否则是多少就是多少
                if (minHp < 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = minHp;
                }
            }
        }
        // 最后返回起点所需最小的生命值
        return dp[0][0];
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/dungeon-game/solution/173-di-xia-cheng-you-xi-liang-lu-xun-zhao-jiao-xia/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

