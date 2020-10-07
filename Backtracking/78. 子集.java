#### [78. 子集](https://leetcode-cn.com/problems/subsets/) + 回溯法求子集

难度：Median

### 解题思路

本题利用回溯法求解数组中的子集

- 首先对数组 **判空**，然后进 **回溯方法体** 进行遍历
- 这里因为要找出所有可能的子集，所以直接加入 `ans` 即可，然后再 **递归** 的遍历后面的元素
- 最后返回 `ans` 即可。

### 代码

```java
class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return ans;
        }
        List<Integer> tmp = new ArrayList<>();
        back(nums, 0, tmp);
        return ans;
    }
    
    private void back(int[] nums, int index, List<Integer> tmp) {
        // 所有情况都放入 ans
        ans.add(new ArrayList<>(tmp));
        
        for (int i = index; i < nums.length; i++) {            
            tmp.add(nums[i]);
            back(nums, i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/subsets/solution/2020042078medianhui-su-fa-qiu-zi-ji-by-jasion_han-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

