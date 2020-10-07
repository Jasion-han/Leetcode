#### [18. 四数之和](https://leetcode-cn.com/problems/4sum/) + 双循环嵌套左右双指针法

难度：Median

### 解题思路

本题为三数之和的加强版

主要思想是利用 **滑动窗口**，利用 **两个索引指针** `l` 和 `r` 在 `i` 和 `j` 之间移动

一定要 **先排序**，可以减少复杂度。然后判空，考虑边界值，去重。

剩下的思路和 **三数之和** 很像了，基本题型就是这样。

### 代码

解法一：

```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);//先排序
        int n = nums.length;
        if(nums == null || nums.length < 4){//判空
            return ans;
        }
        //i为起点，j为终点，l与r构成滑动窗口
        for(int i = 0; i < n - 3; i++){
            if(nums[i] * 4 > target){//如果一开始就比target大，那么后面都比target大，就直接break掉
                break;
            }
            if(i > 0 && nums[i] == nums[i - 1]){//去重
                continue;
            }
            for(int j = n - 1; j - i > 2; j-- ){
                if(nums[j] * 4 < target){//如果最后一个数都比target小，那在他前面的会更小，就直接break掉
                    break;
                }
                if(j < n - 1 && nums[j] == nums[j + 1]){//去重
                    continue;
                }
                int l = i + 1;//i的右边
                int r = j - 1;//j的左边
                while(l < r){
                    int sum = nums[i] + nums[l] + nums[r] + nums[j];
                    if(sum == target){
                        ans.add(Arrays.asList(nums[i],nums[l],nums[r],nums[j]));
                        while(l < n - 2 && nums[l] == nums[l + 1]){//去重
                            l++;
                        }
                        while(r > 2 && nums[r] == nums[r - 1]){//去重
                            r--;
                        }
                        l++;
                        r--;
                    }else if(sum > target){
                        while(r > 2 && nums[r] == nums[r - 1]){//去重
                            r--;
                        }
                        r--;
                    }else if(sum < target){
                        while(l < n - 2 && nums[l] == nums[l + 1]){//去重
                            l++;
                        }
                        l++;
                    }
                }
            }
        }
        return ans;
    }
}
```

解法二：

```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return ans;
        }
        // 一定要先排序
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            // 对 i 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                // 对 j 去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 对 left 去重,这里也可以写 left < right 主要为了和 && 后面的索引一致
                        while (left + 1 < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        // 对 right 去重,这里也可以写 left < right 主要为了和 && 后面的索引一致
                        while (left < right - 1 && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/4sum/solution/2020031718median-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



