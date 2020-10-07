#### [283. 移动零](https://leetcode-cn.com/problems/move-zeroes/) + 使用新索引移动非零元素

难度：Easy

### 解题思路

本题使用一次 `for` 循环，定义一个 `k` 索引从 `- 1` 开始

将非 `0` 元素挨个移动到 `++k` 索引位置，也就是数组前面的位置

遍历完非 `0` 元素后，再将空的位置用 `0` 补齐即可。

### 代码

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int k = -1;
        for(int i = 0; i < n; i++){           
            if(nums[i] != 0){//把不为0的移动到前面              
                nums[++k] = nums[i];
            }      
            if(i != k){//剩下的位置都用0来补
                nums[i] = 0;
            }
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/move-zeroes/solution/20200318283easy-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

