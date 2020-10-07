#### [447. 回旋镖的数量](https://leetcode-cn.com/problems/number-of-boomerangs/) + 典型的排列组合问题

难度：Easy

### 解题思路

本题典型的 **排列组合** 问题，因为题中说 **可以改变顺序**，那么就需要用 **排列公式**  `Anm` = `n` * `m`

- 因为要求距离相等，我们知道 **距离的平方** 也会相等，所以将不开根号的结果传入 `map` 中就可以了
- 最后遍历已经存储的 `keySet`，再利用 **排列公式** 输出结果即可。

### 代码

```java
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        // i 遍历二维数组第一列
        for (int i = 0; i < points.length; i++) {
            // map 中存储点 i 到所有其他点的距离出现的频次
            Map<Integer,Integer> map = new HashMap<>();
            // j 遍历二维数组第二列
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    // 计算距离时不进行开根运算, 以保证精度（反正距离相等）
                    int dis = dis(points[i], points[j] );
                    map.put(dis, map.getOrDefault(dis, 0) + 1);
                }
            }
            // 排列组合，例如：三个数选两个并且可以改变顺序，也就是A32 = 3 * 2
            for (int dis : map.keySet() ) {
                ans += (map.get(dis) ) * (map.get(dis) - 1);
            }
        }
        return ans;
    }
    
    // 计算距离（平方和）
    private int dis(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/number-of-boomerangs/solution/20200325447easy-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

