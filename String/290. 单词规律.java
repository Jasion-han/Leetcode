#### [290. 单词规律](https://leetcode-cn.com/problems/word-pattern/) + 经典 HashMap 方法

难度：Easy

### 解题思路

本题 **关键一步** 就是将 `str` 字符串拆分成字符串数组 `s`，然后再判断和 `pattern` 的对应关系

因为需要判断对应关系，则使用 `HashMap` 来存放数据

通过遍历第一个字符串，先将 **没有保存的数据** 和没有 **一一对应的数据** 筛掉，剩下的就是既有 `K`，又有 `V`

最后就是通过 `equals()` 方法比较每个 `K` 和 `V` 是否具有一一对应关系，如果以上均满足则匹配成功返回 `true`

### 代码

```java
class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] s = str.split(" ");
        // 如果长度不匹配
        if (s.length != pattern.length() ) {
            return false;
        }
        
        HashMap<Character,String> record = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
           // 如果 record 中没有保存当前遍历到的元素
           if ( !record.containsKey(pattern.charAt(i)) ) {
               // 却保存了本该一一对应的数组 s 中的元素
               if (record.containsValue(s[i]) ) {
                   return false;
               }
               // 如果都没有保存，就将其对应关系一同存放进 record 中
               record.put(pattern.charAt(i), s[i]);
           } else {
               // 如果原本就已经保存在 record 中，那就比较其对应关系是否一致
               if ( !record.get(pattern.charAt(i)).equals(s[i]) ) {
                   return false;
               }
           }
        }
        return true;        
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/word-pattern/solution/20200323290easy-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

