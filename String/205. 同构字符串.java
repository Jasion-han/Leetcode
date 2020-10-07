#### [205. 同构字符串](https://leetcode-cn.com/problems/isomorphic-strings/) + 借用双数组进行比较

难度：Easy

### 解题思路

本题使用 **两个数组** 解决对应关系问题

- 首先遍历`s`字符串，将第一次访问的元素在两个数组里 +1，达到对应关系
- 如果访问元素个数不相等，则返回`fasle`

### 代码

```java
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length() ) {
            return false;
        }
        // 定义两个数组来存放字符
        int[] arrS = new int[128];
        int[] arrT = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            // 第一轮先执行 else 部分，如果两个字符串在数组中对应的值不相等
            if (arrS[c1] != arrT[c2]) {
                return false;
            } else {
                // 一开始先进行此操作，表示某元素未遍历过，那么对应记录的个数 + 1
                if (arrS[c1] == 0) {
                    arrS[c1] = i + 1;
                    arrT[c2] = i + 1;
                }
            }
        }
        return true;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/isomorphic-strings/solution/20200324205easy-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

