#### [47. 全排列 II](https://leetcode-cn.com/problems/permutations-ii/) + 回溯法对有重复元素的序列进行排列

难度：Median

### 解题思路

本题大体思路和上一题 `46` 一致，区别已经在注释处标明

- 不同的是这次加入 **重复元素** 进行排序,但却不能重复计算,这可能会遍历大量重复元素,所以需要**剪枝**技术来完成
- **剪枝 **的前提是将 **原数组进行排序**
- 这样可以保证所有重复的元素在一起，那么遍历到第二个重复元素的时候可以与前一个元素进行判断 **是否已经遍历过**
- 所以在后面进入回溯方法体的时候需要多加一条判断规则，进而 **过滤掉重复的元素**。

### 代码

```java
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        // 不同之处！
        // 一定要先排序，排序是剪枝的前提
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        back(nums, ans, new ArrayList<>(), visited);
        return ans;
    }
    
    private void back(int[] nums, List<List<Integer>> ans, ArrayList<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.length) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            // 不同之处！
            // 如果前一个元素已经遍历过，并且和当前元素一样，则继续下一轮循环
            if (i > 0 && visited[i - 1] == 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            visited[i] = 1;
            tmp.add(nums[i]);
            back(nums, ans, tmp, visited);
            tmp.remove(tmp.size() - 1);
            visited[i] = 0;
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/permutations-ii/solution/2020041847medianhui-su-fa-jiang-zhong-fu-yuan-su-j/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

