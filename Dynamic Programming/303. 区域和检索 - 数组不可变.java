#### [303. 区域和检索 - 数组不可变](https://leetcode-cn.com/problems/range-sum-query-immutable/) + 数组不可变 + 动态规划存储前 i 个元素总和

难度：Easy

### 解题思路

- 很巧妙的动态规划题目，运用存储前 `i` 个元素总和来进行计算。

### 代码

```java
class NumArray {

    // 创建额外数组存放下标为 0~i 的和
    private int[] sum;
        
    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            // sum 数组从下标为 1 开始存储原数组前 i 个元素之和
            // 这里留出一个虚拟 0 作为 sum 数组中的第一个元素。这个技巧可以避免在 sumrange 函数中进行额外的条件检查。
            sum[i + 1] = sum[i] + nums[i];
        }
    }
    
    // 例如 2, 5
    // 就代表用前面 6 个元素的和减去前面 2 个元素的和
    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */

作者：Jasion_han
链接：https://leetcode-cn.com/problems/range-sum-query-immutable/solution/303-qu-yu-he-jian-suo-shu-zu-bu-ke-bian-dong-tai-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

