#### [85. 最大矩形](https://leetcode-cn.com/problems/maximal-rectangle/) + 哨兵数组，二维 dp 双解法

难度：Hard

### 解题思路

- 本题是 `84` 题的进阶版本，需要用到上一题的一些思路和解法，具体请看代码。

### 代码

解法一：

```java
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // 前后设立两个哨兵,所以是 + 2
        int[] height = new int[n + 2];
        int ans = 0;
        
        // 扫描每行
        for (int i = 0; i < m; i++) {
            Deque<Integer> stack = new ArrayDeque<>();
            // 扫描每列
            for (int j = 0; j < n + 2; j++) {
                // 如果不是前后两个哨兵才能继续判断
                if (j >= 1 && j <= n) {
                    if (matrix[i][j - 1] == '1') {
                        height[j] += 1;
                    } else {
                        height[j] = 0;
                    }
                }
                // 栈不为空且栈构成的柱子高度呈下降趋势
                // 此时 stack.peek() 为栈内现存最高柱子的下标,j 为第一个下降柱子的下标
                while (!stack.isEmpty() && height[stack.peek()] > height[j]) {
                    int cur = stack.pop();
                    ans = Math.max(ans, (j - stack.peek() - 1) * height[cur]);
                }
                stack.push(j);
            }
        }
        return ans;
    }
}
```



解法二：

```java
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int[][] grid = new int[matrix.length][matrix[0].length];
        
        // 类似于第 84 题先建好柱状图
        buildHistogram(matrix, grid);
        
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            max = Math.max(max, maxRec(grid, i, matrix[i].length));
        }
        return max;
    }

    private void buildHistogram(char[][] matrix, int[][] grid) {
        // 建造第一行的每一列
        for (int j = 0; j < matrix[0].length; j++) {
            grid[0][j] = matrix[0][j] == '1' ? 1 : 0;
        }

        // 从第二行开始构建每一列，若同列连续则下一行数量为上一行数量 + 1, 否则为 0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                grid[i][j] += matrix[i][j] == '0' ? 0 : grid[i - 1][j] + 1;
            }
        }
    }

    // 84 题解法, curIndex 代表横向遍历的索引指针
    private int maxRec(int[][] grid, int bottom, int n) {
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int curIndex = 0;

        while (curIndex < n) {
            while (stack.peek() != -1 && grid[bottom][stack.peek()] >= grid[bottom][curIndex]) {
                max = Math.max(max, grid[bottom][stack.pop()] * (curIndex - stack.peek() - 1));
            }
            stack.push(curIndex);
            curIndex++;
        }

        while (stack.peek() != -1) {
            max = Math.max(max, grid[bottom][stack.pop()] * (curIndex - stack.peek() - 1));
        }
        return max;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/maximal-rectangle/solution/85-zui-da-ju-xing-shao-bing-shu-zu-er-wei-dp-shuan/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

