#### [389. 找不同](https://leetcode-cn.com/problems/find-the-difference/) + 位运算 - 异或

难度：Easy

### 解题思路

本题采用 **异或运算** 主要特点如下：

- 一个数和 `0` 做异或运算等于本身：`a⊕0 = a`

- 一个数和其 **本身** 做异或运算等于 `0`：`a⊕a = 0`
- 异或运算满足 **交换律** 和 **结合律**：`a⊕b⊕a = (a⊕a)⊕b = 0⊕b = b`
- 将所有数字按照顺序做异或运算，最后剩下的结果即为 **唯一** 的数字

### 代码

```java
class Solution {
    public char findTheDifference(String s, String t) {
        char c = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            // 挨个做异或运算
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/find-the-difference/solution/389-zhao-bu-tong-wei-yun-suan-yi-huo-by-jasion_han/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

