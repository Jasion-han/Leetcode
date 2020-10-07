#### [338. 比特位计数](https://leetcode-cn.com/problems/counting-bits/) + 位运算 - 找规律

难度：Median

### 解题思路

- 本题通过列举找出规律即可

  ```
  num   bit  numOf1
  0      0     0
  1      1     1
  2     10     1
  3     11     2
  4    100     1
  5    101     2
  6    110     2
  7    111     3
  8   1000     1
  ```

  

### 代码

```java
class Solution {
    public int[] countBits(int num) {
        
        int[] ans = new int[num + 1];
        ans[0] = 0;
        for (int i = 1; i <= num; i++) {
            // 如果是偶数,比特数中 1 的数量和他一半值是一样的
            if (i % 2 == 0) {
                ans[i] = ans[i / 2];
            } else {
            // 如果是奇数,需要在他一半值的基础上 + 1
                ans[i] = ans[i / 2] + 1;
            }
        }
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/counting-bits/solution/338-bi-te-wei-ji-shu-wei-yun-suan-zhao-gui-lu-by-j/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

