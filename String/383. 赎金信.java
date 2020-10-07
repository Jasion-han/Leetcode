#### [383. 赎金信](https://leetcode-cn.com/problems/ransom-note/) + 巧用数组

难度：Easy

### 解题思路

- 创建一个 `arr` 数组
- 遍历 `magazine` 的内容记录每个字符出现的个数
- 然后继续遍历 `ransomNote` 的内容减去相应字符的个数
- 若出现某个字符的个数小于 `0`，则返回 `false`

- 否则返回 `true`。

### 代码

```java
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        // 因为只包含小写字母，所以用 26 存储空间即可
        int[] arr = new int[26];
        
        for (int i = 0; i < magazine.length(); i++) {
            // 向 arr 数组中记录每个字符的个数
            arr[magazine.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < ransomNote.length(); i++) {
            // 在 arr 数组中对 ransomNote 字符串个数排查减去对应字母后是否 < 0
            if (--arr[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/ransom-note/solution/383shu-jin-xin-shu-zu-by-jasion_han/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```