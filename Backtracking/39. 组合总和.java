#### [39. 组合总和](https://leetcode-cn.com/problems/combination-sum/) + 回溯法组合数字达到目标值

难度：Median

### 解题思路

本题是 `77` 题组合的衍生版

- 这里题目要求找到 **一些数的组合 **使得他们的和与 **目标值 **相等，那么就要用回溯法对数组中的元素逐个进行组合
- 首先对 **特殊情况 **处理，创建程序出口
- 这里要事先对数组进行 **排序**，这样可以在后面的遍历中 **提前结束遍历**
- 然后进入回溯方法体，首先创建方法体出口，也就是当与目标值差为 0 的时候代表找到了一组数据，放入结果集
- 为了 **不重复遍历 **元素，在 `for` 循环内就让 `i` 从 `index` 开始
- 接下来关键一步在循环一开始就先判断目标值是否小于当前遍历元素，如果小于，则说明后面元素都比 `target` 大，直接 `break` 跳出循环，否则才能继续遍历寻找元素直到与 `target` 值相等。
- 遍历完所有元素之后，满足题意的数组对已经放入了结果集，直接返回 `ans` 即可。

### 代码

解法一：

```java
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target < 0) {
            return ans;
        }
        // 排序为了后面可以提前结束遍历
        Arrays.sort(candidates);
        List<Integer> tmp = new ArrayList<>();
        // 回溯
        back(candidates, target, 0, tmp);
        return ans;
    }
    
    private void back(int[] candidates, int target, int index, List<Integer> tmp) {
        // 当目标值为 0，也就是刚好找到某些数的和为 target
        if (target == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        // 这里为了不重复遍历，让 i 从 index 开始
        for (int i = index; i < candidates.length; i++) {
            
            // 在数组有序的前提下剪枝极大提高效率
            if (target - candidates[i] < 0) {
                break;
            }
            tmp.add(candidates[i]);
            back(candidates, target - candidates[i], i, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
```

解法二：

```java
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || target < 1) {
            return ans;
        }
        
        // 排序为了后面剪枝做准备
        Arrays.sort(candidates);
        
        List<Integer> tmp = new ArrayList<>();
        backtrack(candidates, target, ans, tmp, 0);
        return ans;
    }
    private void backtrack(int[] nums, int target, List<List<Integer>> ans, List<Integer> tmp, int index) {
        
        if (target == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            
            // 在数组有序的前提下剪枝极大提高效率
            if (target - nums[i] < 0) {
                break;
            }
            
            tmp.add(nums[i]);
            backtrack(nums, target - nums[i], ans, tmp, i);
            tmp.remove(tmp.size() - 1);
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/combination-sum/solution/2020041939medianhui-su-fa-zu-he-shu-zi-da-dao-mu-b/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

