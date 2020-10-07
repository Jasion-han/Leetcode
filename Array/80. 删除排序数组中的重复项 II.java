#### [80. 删除排序数组中的重复项 II](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/) + 巧用计数器 cnt

难度：Median

### 解题思路

本题用一层 `for`循环完成

设定 **计数器**  `cnt = 1`，满足题意的 **总个数**  `k`

从第二个元素开始遍历，如果和前面的数相等，那么计数器 `cnt++`，不想等则是遇到新的元素，计数器从 `1`开始计数

最后将计数器 `cnt <= 2` 的元素放入新的索引位置 `k` 即可。

### 代码

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int k = 1;
        int cnt = 1;
        for(int i = 1 ; i < n; i++){//从第二个数开始遍历
            if(nums[i] == nums[i - 1]){//如果和前面的数有重复
                cnt++;
            }else{//如果不等则是遇到了新元素，那就对当前元素开始计数依次进行
                cnt = 1;
            }
            if(cnt <= 2){//只有重复元素个数不大于2的时候才将其放入新的索引位置
                nums[k++] = nums[i];
            }
        }      
        return k;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/solution/2020031880median-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



