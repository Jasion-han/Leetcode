#### [16. 最接近的三数之和](https://leetcode-cn.com/problems/3sum-closest/) + 取绝对值比较

难度：Median

### 解题思路

本题是之前三数之和的改编版，这次是求与目标值` target` 最接近的数字

大体思路和之前的一致，这里主要就是用到了 **取绝对值** 进行比较大小，与 `target` **作差** 后将较小的作为结果 `ans` 返回

如果当前三数之和过大，就向左移动减小数字，反之向右移动增大数字。

如果刚好相等则直接返回 `ans` 即可。

### 代码

```java
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = nums[0] + nums[1] + nums[2];//先记录前三个数之和
        for(int i = 0;i < n; i++){
            int l = i + 1;
            int r = n - 1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                //取绝对值与target差值比较选出较小者
                if(Math.abs(target - sum) < Math.abs(target - ans)){
                    ans = sum;
                }
                if(sum > target){//数字大了就向左移动减小总和数
                    r--;
                }else if(sum < target){//数字小了就向右移动增大总和数
                    l++;
                }else{
                    return ans;//如果刚刚好就直接返回即可
                }               
            }
        }
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/3sum-closest/solution/2020131716median-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



