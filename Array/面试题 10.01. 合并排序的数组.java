#### [面试题 10.01. 合并排序的数组](https://leetcode-cn.com/problems/sorted-merge-lcci/) + 逆双指针法

难度：Easy

### 解题思路

本题对两个数组使用了 **逆双指针法**

从两个数组的 **末尾元素** 开始依次比较，把大的放入 `A` 数组后面的位置，依次 **向前移动**

到最后若 `A` 数组有剩余，则不用移动，因为本身就放在了对应的位置。

若 `B` 数组有剩余，则剩几个就放到第几个位置去（其中索引为位置 `- 1`），即可完成合并。

### 代码

```java
class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        while(m > 0 && n > 0){
            //从后往前依次比较两个数组
            A[m + n - 1] = A[m - 1] > B[n - 1] ? A[m-- - 1] : B[n-- - 1];
        }
        while(n > 0){//最后如果B数组有剩余
            A[n - 1] = B[n-- - 1];//剩几个就放到第几个位置去（索引为位置-1）           
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/sorted-merge-lcci/solution/20200314mian-shi-ti-1001easy-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



