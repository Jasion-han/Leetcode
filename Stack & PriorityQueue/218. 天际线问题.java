#### [218. 天际线问题](https://leetcode-cn.com/problems/the-skyline-problem/) + 大顶堆，楼层落差高度

难度：Hard

### 解题思路

本题使用优先队列构建大顶堆完成，具体参考代码注释。

### 代码

```java
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {  
        List<List<Integer>> ans = new ArrayList<>();
        List<int[]> buildLines = new ArrayList<>();
        for (int[] points : buildings) {
            // 存每个建筑的左边界和右边界(左边界高度以负号表示与右边界高度加以区分)
            buildLines.add(new int[]{points[0], -points[2]});
            buildLines.add(new int[]{points[1], points[2]});
        }
        
        Collections.sort(buildLines, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                // 若在同一边界处，将 height 以降序排序
                // 也就是在左边界选择高的(因为左边是负数)，右边界的时候选择低的
                return a[1] - b[1];
            }
        });
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.add(0);
        int preHeight = 0;
        // 此时只包含左边界和对应的高度
        for (int[] points : buildLines) {
            // 如果是刚扫描到左边界则将左边界高度放进去
            if (points[1] < 0) {
                maxHeap.add(-points[1]);
            // 否则说明已经遍历完该楼层,需要将该高度移除遍历下一楼层高度
            } else {
                maxHeap.remove(points[1]);
            }
            // 更新当前高度
            int curHeight = maxHeap.peek();
            // 如果有落差说明是错落楼层,需要将该处的左边界和当前高度放入 ans
            if (curHeight != preHeight) {
                ans.add(Arrays.asList(points[0], curHeight));
                // 更新前一个高度为此时的高度
                preHeight = curHeight;
            }
        }
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/the-skyline-problem/solution/218-tian-ji-xian-wen-ti-da-ding-dui-lou-ceng-luo-c/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

