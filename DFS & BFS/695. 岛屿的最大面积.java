#### [695. 岛屿的最大面积](https://leetcode-cn.com/problems/max-area-of-island/) + 上下左右分别寻找岛屿

难度：Median

### 解题思路

本题使用 **DFS（深度搜索）**来寻找岛屿数量

先用两层 `for` 循环寻找值为 `1` 的数字（即岛屿），之后使用 `DFS` 分别在该值的上下左右分别寻找 `1`

将寻找到的 `1` 标记为 `0` 以免重复搜索，同时用计数器 `num` 来记录搜索到岛屿的数量（即题中的最大面积）

### 代码

```java
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ret = 0;
        for(int i = 0 ;i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    ret = Math.max(ret, dfs(grid, i, j));
                }
            }
        }
        return ret;
    }
    
    private int dfs(int grid[][], int i ,int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;//将满足条件的岛屿先置为0，以免多次访问
        int num = 1;//使用计数器记录岛屿数量，也就是题中所说的岛屿面积
        num += dfs(grid , i - 1, j);//向上寻找
        num += dfs(grid , i + 1 , j);//向下寻找
        num += dfs(grid , i , j - 1);//向左寻找
        num += dfs(grid , i , j + 1);//向右寻找
        return num;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/max-area-of-island/solution/20200316695median-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



