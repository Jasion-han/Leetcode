#### [26. 删除排序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/) + 移动非重复元素

难度：Easy

### 解题思路

本题是在 **已排好序** 的数组中删除重复的元素

将非重复元素移动到数组前面即可

其中用到 **优化** ：如果是 `0，1，3，4，5` 这样的数组顺序就不需要移动元素了

### 代码

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[l]){
                if(i - l > 1){//优化：如果是0，1，3，4，5这样的顺序就不需要移动了
                    nums[l + 1] = nums[i];
                }   
                l++;
            }            
        }
        return l + 1;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/2020031426easy-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

