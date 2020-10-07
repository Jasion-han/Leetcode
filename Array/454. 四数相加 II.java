#### [454. 四数相加 II](https://leetcode-cn.com/problems/4sum-ii/) + 分组在 HashMap 中进行匹配

难度：Median

### 解题思路

本题是利用 `HashMap `记录元素对，而最佳思路是将数组 `A` 和 `B` 的和记录到一起，再将另外一组记录到一起

- 通过双循环将 **前两个数组** 的每个元素之和加起来放入`map`中，然后再双循环遍历 **后两组 **的每对元素

- 将后两组元素之和 **取反** 后去 `map` 找是否有相等的，有则用 `cnt` 记录，即为满足题意的个数

### 代码

```java
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // 定义 map 来存储数组 A 和 B 每对元素的键值对
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                // 定义 sum1 来保存元素之和
                int sum1 = A[i] + B[j];
                map.put(sum1, map.getOrDefault(sum1, 0) + 1);
            }
        }
        
        // 定义 cnt 来记录满足题目的个数
        int cnt = 0;
        // 将数组 C 和 D 的每对元素也记录起来  
        for (int k = 0; k < C.length; k++) {
            for (int l = 0; l < D.length; l++) {
                // 定义 sum2 记录取反后的每对元素之和
                int sum2 = - ( C[k] + D[l] );
                // 若 map 里有与 sum2 相等的，则满足要求，加入计数器 cnt
                if (map.containsKey(sum2) ) {
                    cnt += map.get(sum2);
                }
            }
        }
        return cnt;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/4sum-ii/solution/20200325454median-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

