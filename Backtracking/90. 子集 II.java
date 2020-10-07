#### [90. 子集 II](https://leetcode-cn.com/problems/subsets-ii/) + 回溯法寻找数组中非重复子集

难度：Median

### 解题思路

本题和 `78` 题很相似，**区别 **就在于此题要求 **不包含重复的子集**

- 其他步骤和 `78` 题一模一样，最主要的区别就是要在递归遍历前先将数组 **排好序**
- 这样在后面的循环中就可以判断 **当前元素是否和上一轮中遍历过的元素重复 **从而筛选出 **非重复 **的子集
- 最后找到的即为答案，传入 `ans` 并返回即可

### 代码

```java
class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return ans;
        }
        // 先将数组排好序，必要操作
        Arrays.sort(nums);
        List<Integer> tmp = new ArrayList<>();
        // 回溯
        back(nums, 0, tmp);
        return ans;
    }
    
    private void back(int[] nums, int index, List<Integer> tmp) {
        // 所有可能的子集都加入 ans 中
        ans.add(new ArrayList<>(tmp));
        for (int i = index; i < nums.length; i++) {
            // 排除与上一轮遍历中重复的子集
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            tmp.add(nums[i]);
            back(nums, i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/subsets-ii/solution/2020042090medianhui-su-fa-xun-zhao-shu-zu-zhong-fe/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

