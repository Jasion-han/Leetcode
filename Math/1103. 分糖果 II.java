#### [1103. 分糖果 II](https://leetcode-cn.com/problems/distribute-candies-to-people/) + 数组与数学公式的结合

难度：Easy

### 解题思路

简单的思路就是拿需要分发的数量和剩下的糖果数量做比较，将较小者作为结果发给目标小朋友

这里应该注意一下 Math.min(candies, **i + n * num_people**)

如果需要分发 **多轮**，则在for循环后轮数 **n 要 + 1**。

### 代码

```java
class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int ans[] = new int[num_people];
        int n = 0;//轮数，0为第一轮分发糖果
        
        while (candies > 0) {
            for (int i = 1; i <= num_people; i++) {
                //将要分发的数量和糖果剩下的数量进行比较
                ans[i - 1] += Math.min(candies, i + n * num_people);
                candies -= (i + n * num_people);
                if (candies <= 0) {
                    break;
                }
            }
            n++;//前面一轮分发完毕，进行下一轮分发（从第一个小朋友继续）
        } 
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/distribute-candies-to-people/solution/20200305mei-ri-yi-ti-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

