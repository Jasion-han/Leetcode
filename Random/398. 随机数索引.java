#### [398. 随机数索引](https://leetcode-cn.com/problems/random-pick-index/) + 随机命中法

难度：Median

### 解题思路

注意几点:

- 该方法的作用是生成一个随机的 `int` 值，该值介于 `[0,n)` 的区间，也就是 `0` 到 `n` 之间的随机 `int` 值，包含 `0` 而不包含 `n`

  ```
  public int nextInt(int n)
  ```

- 第一次命中 `3` 后 `count` 变成 `1`,那么随机值百分百为 `0`;第二次命中的话, `count` 就成了 `2` ,随机值可以取到 `0` 和 `1`,即变成了 `1/2` 的概率,以此类推

  ```
  if (rdm.nextInt(count) == 0) {
      ans = i;
  }
  ```

### 代码

```java
class Solution {
    
    // 创建原始数组 nums 和随机数
    private int[] nums;
    private Random rdm;

    public Solution(int[] nums) {
        this.nums = nums;
        rdm = new Random();
    }
    
    public int pick(int target) {
        int ans = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            // 未命中则继续
            if (nums[i] != target) {
                continue;
            }
            // 若命中 count 先加一
            count++;
            // 该方法的作用是生成一个随机的 int 值，该值介于 [0, count)的区间，也就是 0 到 count 之间的随机 int 值，包含 0 而不包含 count
            // 第一次命中 3 后 count 变成 1,那么随机值百分百为 0;第二次命中的话,count 就成了 2,随机值可以取到 0 和 1,即变成了 1/2 的概率,以此类推
            if (rdm.nextInt(count) == 0) {
                ans = i;
            }
        }
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */

作者：Jasion_han
链接：https://leetcode-cn.com/problems/random-pick-index/solution/398-sui-ji-shu-suo-yin-sui-ji-ming-zhong-fa-by-jas/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

