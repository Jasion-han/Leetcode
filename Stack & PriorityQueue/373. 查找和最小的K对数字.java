#### [373. 查找和最小的K对数字](https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/) + PQ建立小顶堆，索引更新小技巧

难度：Median

### 解题思路

- 本题使用优先队列建立 **小顶堆**
- 弹出小顶堆的 **堆顶元素** 即最小值

- 控制弹出次数为 `k` 即可获取前 `K` 小的元素

### 代码

```java
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return ans;
        }
        // 建立小顶堆
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));
        for (int i = 0; i < nums1.length && i < k; i++) {
            // 放入三个元素,第三个元素放的是第二个元素的索引值
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }
        // 注意两个条件
        while (!pq.isEmpty() && k-- > 0) {
            int[] cur = pq.poll();
            // 这里如果题目给出的是 List<int[]>,那么括号里可以写 new int[]{cur[0], cur[1]}
            ans.add(Arrays.asList(cur[0], cur[1]));
            if (cur[2] == nums2.length - 1) {
                continue;
            }
            // 这里 cur[2] + 1 就是把 nums2 中的索引向后移一位
            pq.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/solution/373-cha-zhao-he-zui-xiao-de-kdui-shu-zi-pqjian-li-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

