#### [75. 颜色分类](https://leetcode-cn.com/problems/sort-colors/) + 三路快排法

难度：Median

### 解题思路

本题使用 **三路快排**，定义 **当前移动** 索引指针 `cur`，左边 **放 0** 的索引 `l`，右边 **放 2** 的索引 `r`

依次遍历一遍数组，通过 `while` 循环将当前索引指针 `cur` 访问到的元素放到正确的位置去即可。

### 代码

```java
class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }
        int l = -1;//定义左边索引位置
        int r = len - 1;//定义右边索引位置
        int cur = 0;//定义当前移动索引指针

        while (cur <= r) {//当前移动索引指针位置不能超过右索引指针访问位置
            if (nums[cur] == 0) {//如果当前访问元素是0
                l++;//要将一开始定义的-1变成0
                swap(nums, cur, l);
                cur++;
            } else if (nums[cur] == 1) {//如果当前访问元素是1
                cur++;
            } else {
                swap(nums, cur, r);//如果当前访问元素是2
                r--;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/sort-colors/solution/2020031975median-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



