#### [66. 加一](https://leetcode-cn.com/problems/plus-one/) + 三种情况

难度：Easy

### 解题思路

从个位开始加一，会遇到三种情况。每种情况分别考虑即可。

### 代码

```java
class Solution {
    public int[] plusOne(int[] digits) {
        // 从个位开始计算
        int i = digits.length - 1;
        
        while (i >= 0) {
            // 123 -> 124
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // 129 -> 130
            digits[i] = 0;
            i--;
        }
        
        // 99 -> 100
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/plus-one/solution/66-jia-yi-san-chong-qing-kuang-by-jasion_han/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

