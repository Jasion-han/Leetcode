#### [171. Excel表列序号](https://leetcode-cn.com/problems/excel-sheet-column-number/) + 字母转数字

难度：Easy

### 解题思路

看代码！

### 代码

```java
class Solution {
    public int titleToNumber(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            // 将每个字母转成对应数字
            int num = s.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/excel-sheet-column-number/solution/171-excelbiao-lie-xu-hao-zi-mu-zhuan-shu-zi-by-jas/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

