#### [40. 组合总和 II](https://leetcode-cn.com/problems/combination-sum-ii/) + 回溯法对非重复数字进行组合

难度：Median

### 解题思路

本题是上一题 `39` 的改编版，相似度很大，相似问题请看上一题的题解

- 这里与上一题的 **区别 **已经在注释处标明

- 主要是将 **重复的元素过滤掉**，每次循环开始时，当前元素是否和上一个元素相等，若相等要 **跳过 **该元素
- 之后从 `i + 1` 位置开始调用，遍历后面的元素直到全部遍历完成即可。

### 代码

解法一：

```java
class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target < 0) {
            return ans;
        }
        Arrays.sort(candidates);
        List<Integer> tmp = new ArrayList<>();
        back(candidates, target, 0, tmp);
        return ans;
    }
    
    private void back(int[] candidates, int target, int index, List<Integer> tmp){
        if (target == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            // 这里需要判断当前元素是否和前一个相等,若是则不需要考虑,继续下一轮循环
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (target - candidates[i] >= 0) {
                tmp.add(candidates[i]);
                                        // 接下来 i 从他后一个元素开始遍历
                back(candidates, target - candidates[i], i + 1, tmp);
                tmp.remove(tmp.size() - 1);
            }            
        }
    }
}

//[10,1,2,7,6,1,5] => [1,1,2,5,6,7,10]  target=8
//假设现在寻找第一个加数，nums[0] = 1 ,第一个加数是位置0的1，然后可以找到 [1,1,6] [1,7]，最后递归回归到i=0，即寻找第一个加数的递归函数
//尝试nums[1]作为第一个加数, 此时发现nums[1] = nums[0] ,那么递归下去一定可以找到重复的解[1,7], 因此跳过nums[1]
// i > l的目的是 确保不是第一次使用这个加数，如果不保证i > l, 那么[1,1,6]这样的解就会丢失
```



解法二：

```java
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || target < 1) {
            return ans;
        }
        
        // 重要的排序
        Arrays.sort(candidates);
        
        List<Integer> tmp = new ArrayList<>();
        backtrack(candidates, target, ans, tmp, 0);
        return ans;
    }
    
    private void backtrack(int[] nums, int target, List<List<Integer>> ans, List<Integer> tmp, int index) {
        // 提前判断，提高执行效率
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            
            // 从第二个元素开始比较是否和前一个元素重复
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            // 做判断提高效率
            if (target - nums[i] >= 0) {
                tmp.add(nums[i]);
                backtrack(nums, target - nums[i], ans, tmp, i + 1);
                tmp.remove(tmp.size() - 1);
            }
            
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/combination-sum-ii/solution/2020041940medianhui-su-fa-dui-fei-zhong-fu-shu-zi-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

