#### [27. 移除元素](https://leetcode-cn.com/problems/remove-element/) + 使用新索引原地移除目标元素

难度：Easy

### 解题思路

本题和 `83` 题很像，只是这个索引 **k 是从 0 开始**，用 `while` 循环依次遍历数组，将满足题意的元素赋值给 `k` 索引所在位置即可

### 代码

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int k = 0;
        int i = 0;
        while(i < n){
            if(nums[i] != val){
                nums[k++] = nums[i];
            }
            i++;
        }
        return k;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/remove-element/solution/2020031827easy-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

