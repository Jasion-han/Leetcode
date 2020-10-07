#### [84. 柱状图中最大的矩形](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/) + 哨兵数组，降序柱子再动手

难度: Hard

### 解题思路

本题借用威哥 **liweiwei1419** 解题动画及思路完成

- 这里使用 **哨兵数组** 减少非空操作，同时统一了解题步骤
- 另外使用了定义栈的最新写法 `Deque`，更加规范

- 其中关键点在于求出高度和宽度，那么 **高度** 就应该选在即将降序的柱子，因为它相当与"大顶堆",之后再将其两侧的索引相减即为 **宽度**，最后相乘即为面积

- 为了寻找 **最大面积**，就不断的遍历每种能够构成面积的情况选出最大值即可。

### 代码

解法一：

```java
class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        // 定义面积
        int area = 0;
        
        // 使用带哨兵的数组(最左端和最右端各添一个高度为 0 的元素)
        int[] newHeights = new int[len + 2];
        for (int i = 0; i < len; i++) {
            newHeights[i + 1] = heights[i];
        }
        len += 2;
        heights = newHeights;
        
        // 定义栈的新方法
        Deque<Integer> stack = new ArrayDeque<>();
        // 先加入一个哨兵
        stack.add(0);
        // 从第二个位置开始遍历
        for (int i = 1; i < len; i++) {
            // 当遇到下降趋势的柱子开始计算面积,每次计算完后高柱子出栈,再将次高柱子作为高柱子继续计算
            while (heights[i] < heights[stack.peekLast()]) {
                // 定义高度为下降柱子中的高者
                int height = heights[stack.removeLast()];
                // 定义宽度为当前柱子索引 - 高柱子左边的索引 - 1
                int width = i - stack.peekLast() - 1;
                
                area = Math.max(area, width * height);
            }
            stack.add(i);
        }
        return area;
    }
}
```

解法二：

```java
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                max = Math.max(max, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            
            stack.push(i);
        }
        
        while (stack.peek() != -1) {
            max = Math.max(max, heights[stack.pop()] * (n - stack.peek() - 1));
        }
        
        return max;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/84-zhu-zhuang-tu-zhong-zui-da-de-ju-xing-shao-bi-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

