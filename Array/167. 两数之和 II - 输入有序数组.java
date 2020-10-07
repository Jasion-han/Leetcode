#### [167. 两数之和 II - 输入有序数组](https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/) + 双索引指针进行二分查找

难度：Easy

### 解题思路

本题使用 **双索引指针** 一前一后进行比较输出

通过 `while` 循环，一次遍历整个数组，当 `sum == target` 的时候 将下标 `+ 1` 的位置值放入新的数组 `new int[]` 中

否则就移动左右索引指针，如果最后没有找到满足题意的值则返回 `null` 即可。

###  代码

```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }

        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                //将满足题意的位置放入新的数组
                return new int[] {left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/solution/20200320167easy-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



