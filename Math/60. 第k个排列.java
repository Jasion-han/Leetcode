#### [60. 第k个排列](https://leetcode-cn.com/problems/permutation-sequence/) + 找规律题目，需要自己带入例子解决

难度：Hard

### 解题思路

本题很 tricky，根据自己带入例子画图跑了一遍就明白大致意思了
思路是
对每一个 `ans` 从左到右做分析，
比如 第 `0` 位，
1(23)
1(32)

2(13)
2(31)

3(12)
3(21)

每个数字有 `(n - 1)!` 即 `2!` 个排序
那么我根据 `k` 就能找到 第一个数字是 `2`

---> k 变成了`(3 - 2!)`
剩下的数字是 `(1, 2)`
同理能得到剩下的数字

### 代码

```java
class Solution {
                            // 以 n = 3, k = 3 为例
    public String getPermutation(int n, int k) {
        List<Integer> ans = new ArrayList<>();
        // 事先将 1 2 3 放入 ans
        for (int i = 1; i <= n; i++) {
            ans.add(i);
        }
        int[] fact = new int[n];
        // 第一组首元素一定是 1
        fact[0] = 1;
        // 求剩下元素在对于每个 i 情况下的阶乘 n!
        for (int i = 1; i < n; i++) {
            // 当 i 是 1，就是 1!
            // 当 i 是 2，就是 2!
            fact[i] = i * fact[i - 1];
        }
        // 转变为找下标是第 k - 1 的排列情况
        k = k - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int index = k / fact[i - 1];
            // 去掉上一轮计算过的数，初始下一轮的 k
            k = k % fact[i - 1];
            // 找到的第一个数先加到 sb 后面
            sb.append(ans.get(index));
            // 然后再把原来位置上的这个数去除掉
            ans.remove(index);
        }
        return sb.toString();
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/permutation-sequence/solution/60-di-kge-pai-lie-zhao-gui-lu-ti-mu-xu-yao-zi-ji-d/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

