#### [31. 下一个排列](https://leetcode-cn.com/problems/next-permutation/) + 熟背此类题目的解法

难度：Median

### 解题思路

- 这道题感觉没有什么特殊的技巧，就是背下来
- `i` 从倒数第二个位置往前，找到第一个降序的元素 `x`；若走到头还没有找到降序元素则直接反转整个数组

- `j` 从倒数第一个位置往前，找到第一个比元素 `x` 大的元素 `y`
- 交换 `x` 和 `y` 两元素的值

- 将 `x` 之后的所有元素（不包括 `x`）逆序。

### 代码

```java
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // 如果完全逆序并且 i 走到了第一个元素的前一个空位，直接反转整个
        if (i == -1) {
            reverse(nums, i + 1);
            return;
        }
        
        int j = nums.length - 1;
        while (j >= 0 && nums[j] <= nums[i]) {
            j--;
        }
        
        // 交换两元素值
        swap(nums, i, j);
        // 反转 i + 1 之后的所有元素
        reverse(nums, i + 1);
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private void reverse(int[] nums, int i) {
        int left = i;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/next-permutation/solution/31-xia-yi-ge-pai-lie-shou-bei-ci-lei-ti-mu-de-jie-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

