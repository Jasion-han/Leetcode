#### [268. 缺失数字](https://leetcode-cn.com/problems/missing-number/) + 利用求和公式，利用异或特点

难度：Easy

### 解题思路

本题给出两种思路

- 第一种是根据数学的 **求和公式** 来找出 **缺少** 的那个数字

- 第二种是根据位运算，并且需要注意 **异或** 的几个特点：
  1、每个数异或自己等于 0；

  2、每个数异或 0 等于自己；
  3、异或的交换律；

- 题目描述该数组是 `0 ~ n` 之间缺少一个数的不重复序列，那么我们需要把 **数组的所有元素** 先异或一遍
- 然后再和 **完整的数字个数** `0 ~ n` 进行异或，最后得出的数就是缺失的数。

### 代码

解法一：

```java
class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        // 将数组中现有元素加起来
        for (int i : nums) {
            sum += i;
        }
        // 因为缺少一个数,所以 n 需要加上 1
        int n = nums.length + 1;
        // 根据求和公式找出缺少的那个数字即可
        return (n * (n - 1) / 2) - sum;
    }
}
```



解法二：

```java
class Solution {
    public int missingNumber(int[] nums) {
        int ans = 0;
        // 先把数组中所有的数进行异或
        for (int num : nums) {
            ans ^= num;
        }
        // 再和从 0 到 n 完整的数字进行异或
        for (int i = 0; i <= nums.length; i++) {
            ans ^= i;
        }
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/missing-number/solution/268-que-shi-shu-zi-qiu-he-gong-shi-zuo-chai-by-jas/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

