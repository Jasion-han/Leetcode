#### [387. 字符串中的第一个唯一字符](https://leetcode-cn.com/problems/first-unique-character-in-a-string/) + 借用数组存储

难度：Easy

### 解题思路

暂无

### 代码

```java
class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        
        // 用数组存放每个字母以及出现的次数
        int[] cnt = new int[256];
        for (char c : s.toCharArray()) {
            cnt[c]++;
        }
        
        // 再次遍历字符串 s 将满足题意得找出来返回其索引即可
        for (int i = 0; i < s.length(); i++) {
            if (cnt[s.charAt(i)]== 1) {
                return i;
            }
        }
        return -1;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string/solution/387zi-fu-chuan-zhong-de-di-yi-ge-wei-yi-zi-fu-shu-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

