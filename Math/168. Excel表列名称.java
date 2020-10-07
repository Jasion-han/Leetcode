#### [168. Excel表列名称](https://leetcode-cn.com/problems/excel-sheet-column-title/) + 数字转字母

难度: Easy

### 解题思路

- 这个题目的坑在于下标不是从 `0` 开始，而是从 `1` 开始！
- 所以如果要用进制转换的思路来解决的话，在处理每一位的时候要把当前的位进行减 `1` 操作

- 因为每次都是拼接的余数，所以最后要反转一下即可。

### 代码

```java
class Solution {
    public String convertToTitle(int n) {
        StringBuilder ans = new StringBuilder();
        while (n != 0) {
            // 这里--是为了让下表从 0 开始
            n--;
            ans.append((char)(n % 26 + 'A'));
            n /= 26;
        }
        // 因为每次都是加的余数，所以最后需要反转一下
        return ans.reverse().toString();
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/excel-sheet-column-title/solution/168-excelbiao-lie-ming-cheng-jin-zhi-zhuan-huan-we/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

