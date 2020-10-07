#### [96. 不同的二叉搜索树](https://leetcode-cn.com/problems/unique-binary-search-trees/) + DP 卡特兰数

难度：Median

### 解题思路

- 解法一使用递归依次将每个 `i` 作为根时的左右子树节点数相乘之后累加得出结果
- 解法二是通过双循环 `DP` 和 **卡特兰数** 进行相乘累加，效率明显提升

### 代码

解法一：

```java
class Solution {
    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 以每个 i 为根下的[左子树节点个数 * 右子树节点个数]累加
            ans += numTrees(i) * numTrees(n - 1 - i);
        }
        return ans;
    }
}
```



解法二：

```java
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        // 卡特兰数计算
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        // 最后存的就是最大种类数
        return dp[n];
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/unique-binary-search-trees/solution/96-bu-tong-de-er-cha-sou-suo-shu-dpqia-te-lan-sh-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

