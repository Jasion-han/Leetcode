#### [1. 两数之和](https://leetcode-cn.com/problems/two-sum/) + 哈希表	

难度：Easy

### 解题思路

这道题是求两数之和，一开始想到的是通过两次 `for` 循环遍历得出结果，但是时间复杂度太大了。
然后参考官网给出的最优解学会了用哈希表来优化代码

### 代码

解法一：

``` java
class Solution {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer, Integer> map = new HashMap<>();
       for(int i = 0; i < nums.length; i++){
           int implement = target - nums[i];
           if(map.containsKey(implement)){
               return new int[] {map.get(implement),i};
           }
           map.put(nums[i],i);
       }
       throw new IllegalArgumentException("No two sum solution");
    }
}
```

解法二：

``` java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                ans[0] = i;
                ans[1] = map.get(diff);
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/two-sum/solution/20200305shua-ti-kai-shi-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

