#### [49. 字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/) + 巧用 Map 和 List 共同解决问题

难度：Median

### 解题思路

本题涉及了 `Map` 和 `List` 共同存放字母异位词组

- 整个过程经历了 **字符串数组 -> 字符数组 -> 字典顺序排序 -> 字符串数组**
- 通过以上转换后再按分类依次放入 `Map` 中
- 如果 **第一次存放** 就先创建 `List` 数组将 **该字符串以及异位词** 一起作为 `Map` 中的 `Value` 再放入 `Map` 中
- 如果 `Map` 中 **已经存放了异位词**，就将 **转换前** 的元素放入与该异位词相同的 `Value` 中

### 代码

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        // 这里如果 String 是 "tea",那么 List<String> 放["ate","eat","tea"]
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 每遍历一个字符串就先将其转换成多个字符
            char[] ch = str.toCharArray();
            // 将多个字符按字典顺序排好序
            Arrays.sort(ch);
            // 然后将排好序的所有字符再转成字符串
            String key = String.valueOf(ch);
            if (map.containsKey(key) ) {
                // 如果 map 中有相同的就将其转换之前的 str 放入 map 的键中
                map.get(key).add(str);
            } else {
                // 如果没有就创建新的 list 数组存放 map 中不相同的元素
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/group-anagrams/solution/2020032549median-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

