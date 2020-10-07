#### [11. 盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/) + 左右双指针法

难度：Median

### 解题思路

本题使用 **双指针法** 进行求解

定义左边界索引 `l`，右边界索引 `r` 通过比较 索引距离（r-l）* 两个索引的高度最小值 `Math.min(height[l], height[r])`

每次得到的结果都要和上次结果进行比较取最大值，这样所得即是最大值了。

复杂度分析：

时间复杂度：O(n)，一次扫描。
空间复杂度：O(1)，使用恒定的空间。

### 代码

```java
class Solution {
    public int maxArea(int[] height) {
        int l = 0;//定义左边界
        int r = height.length - 1;//定义右边界
        int max = 0;
        while(l < r){
            max = Math.max(max , Math.min(height[l],height[r]) * (r - l));//外面的面积取最大值，里面的高度要取最小值      
            if(height[l] < height[r]){
                l++;//左边界小于右边界，则左边界向右移动
            }else{
                r--;//同上
            }
        }
        return max;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/container-with-most-water/solution/2020031211median-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



