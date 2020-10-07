#### [46. 全排列](https://leetcode-cn.com/problems/permutations/) + 回溯法对数字进行排列

难度：Median

### 解题思路

本题标准 **回溯法** 进行全排列

- 前面回溯的题目也已经有解释了，这里注意几点：
- 创建 `visited` 数组来记录访问过的元素，**以免重复访问**。
- 当找到符合题意的一组数据后，应该以 new 的形式放入结果集 `ans` 中，因为每次 `tmp` 都会变化，应该先将已经确定下来的数组放入到 `ans` 中，再去寻找下一组数据


- 还有在遍历元素之前将 `visited` 数组下标置为 `1` 以示访问，回溯结束之后还要将下标恢复 `0`，便于下次计算。

### 代码

```java
class Solution {    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // 记录已经遍历过的元素，防止重复计算
        int[] visited = new int[nums.length];
        if (nums == null || nums.length == 0) {
            return ans;
        }
        // 回溯
        back(nums, ans, new ArrayList<>(), visited);
        return ans;
    }
    
    private void back(int[] nums, List<List<Integer>> ans, ArrayList<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.length) {
            // 再次提醒，这里一定要用 new 出来的
            ans.add(new ArrayList<>(tmp));
            return;
        }
        // 这里每次都要从第一个元素开始遍历
        for (int i = 0; i < nums.length; i++) {
            if (visited [i] == 1) {
                continue;
            }
            
            // 每当遍历到一个元素就将其下标置为 1，代表将要遍历
            visited [i] = 1;
            tmp.add(nums[i]);            
            back(nums, ans, tmp, visited); 
            tmp.remove(tmp.size() - 1);
            // 遍历完再将其置为 0
            visited[i] = 0;
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/permutations/solution/2020041846medianhui-su-fa-dui-shu-zi-jin-xing-pai-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

