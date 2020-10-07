#### [322. 零钱兑换](https://leetcode-cn.com/problems/coin-change/) + 动态规划拆分为子问题解决

难度：Median

### 解题思路

对于本题，以 `coins = [1, 2, 5]`, `amount = 11` 为例
我们要求组成 `11` 的最少硬币数，可以考虑组合中的最后一个硬币分别是 `1，2，5` 的情况，比如

最后一个硬币是 1 的话，最少硬币数应该为【组成 10 的最少硬币数】+ 1 枚的 1 块硬币
最后一个硬币是 2 的话，最少硬币数应该为【组成 9 的最少硬币数】+ 1 枚的 2 块硬币
最后一个硬币是 5 的话，最少硬币数应该为【组成 6 的最少硬币数】+ 1 枚的 5 块硬币
在这 3 种情况中硬币数最少的那个就是结果

按同样的道理，我们也可以分别再求出组成 10 的最少硬币数，组成 9 的最少硬币数，组成 6 的最少硬币数
我们发现这种当前状态的问题可以转化成之前的状态问题，一般就是动态规划的套路
所以我们自底向上依次求组成 1，2... 一直到 11 的最少硬币数
对每一个数，依次比较最后一个硬币是不同面额的情况，从中选出最小值
⚠️注意：这里有两个小技巧：

预设一个 0 位方便后续计算，组成 0 的最少硬币数是 0，所以 dp[0] = 0
给每一个数预设一个最小值 amount + 1，因为硬币面额最小为整数 1，所以只要有解，最小硬币数必然小于amount+1
则 dp 的最后一项就是答案
题解转自 Teki

### 代码

```java
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (coins == null || coins.length == 0) {
            return -1;
        }
        
        // dp[amount]的值表示凑成总金额为 amount 所需的最少的硬币个数
        int[] dp = new int[amount + 1];
        // amount + 1 是不可能达到的换取数量,于是使用其进行填充,类似于初始为最大值
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        
        // 外层 for 循环在遍历所有状态的所有取值
        for (int i = 1; i <= amount; i++) {
            // 内层 for 循环在求所有选择的最小值
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    // 重点！表示在子问题中寻找最小值,拿 amount = 11 为例
                    // dp[i - coins[j]] + 1 表示以 10,9,6 为目标所需硬币最少个数
                    // 最后再加上各自对应所缺少的那一枚即可
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        // 最后判断目标所需硬币数量是否改变
        return dp[amount] == (amount + 1) ? -1 : dp[amount];
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/coin-change/solution/322-ling-qian-dui-huan-dong-tai-gui-hua-chai-fen-w/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

