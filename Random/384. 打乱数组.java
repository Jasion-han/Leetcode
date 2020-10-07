#### [384. 打乱数组](https://leetcode-cn.com/problems/shuffle-an-array/) + 随机数法

难度：Median

### 解题思路

随机大法好

### 代码

```java
class Solution {

    // 创建 nums 数组和随机数
    private int[] nums;
    private Random rdm;
    
    public Solution(int[] nums) {
        this.nums = nums;
        rdm = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (nums == null) {
            return null;
        }
        
        // 克隆数组
        int[] clone = nums.clone();
        for (int i = 1; i < clone.length; i++) {
            int random = rdm.nextInt(i + 1);
            if (random == i) {
                continue;
            }
            swap(clone, i, random);
        }
        return clone;
    }
    
    private void swap(int[] clone, int i, int j) {
        int tmp = clone[i];
        clone[i] = clone[j];
        clone[j] = tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

作者：Jasion_han
链接：https://leetcode-cn.com/problems/shuffle-an-array/solution/384-da-luan-shu-zu-sui-ji-shu-fa-by-jasion_han/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

