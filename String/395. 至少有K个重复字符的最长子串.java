#### [395. 至少有K个重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/) + 哈希，递归

难度：Median

### 解题思路

提供两种代码思路。

### 代码

解法一：

```java
class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (char chs : s.toCharArray()) {
            map.put(chs, map.getOrDefault(chs, 0) + 1);
        }
        
        // 这里是先把 s 传进 sb 中来找出不满足 k 个的元素及其位置
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) < k) {
                sb.setCharAt(i, ',');
            }
        }
        
        // 然后以不符合要求的元素位置进行分割存储到字符串数组中
        String[] string = sb.toString().split(",");
        // 如果仅有一组，则说明只有一个字母，返回首字母既可
        if (string.length == 1) {
            return string[0].length();
        }
        int max = 0;
        // 如果有多组，就进行最大值比较
        // 例如 aaabcccc，通过上面的操作后 化为 aaa,cccc
        for (String str : string) {
            max = Math.max(max, longestSubstring(str, k));
        }
        return max;
    }
}
```

解法二：

```java
class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        // 使用数组存储，效率高
        // 若包含大写字母，可以用128，如果包含其他ASCII码，可用256
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        
        // 是否整个字符串都符合要求
        boolean fullString = true;        
        for (int i = 0; i < s.length(); i++) {
            // 若有字母小于 k 个，则说明整个字符串不符合，需要拆开来判断
            if (hash[s.charAt(i) - 'a'] > 0 && hash[s.charAt(i) - 'a'] < k) {
                fullString = false;
            }
        }
        if (fullString == true) {
            return s.length();
        }
        
        // 滑动窗口
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < s.length()) {
            // 如果遇到 right 所指元素个数小于 k，则需要由此拆开来比较其他位置
            if (hash[s.charAt(right) - 'a'] < k) {
                // aaabcccc
                // l  r     左闭右开，所以取到的是 aaa
                max = Math.max(max, longestSubstring(s.substring(left, right), k));
                left = right + 1;
            }
            right++;
        }
        // aaabcccc
        //     l   r  即取到的是 cccc
        max = Math.max(max, longestSubstring(s.substring(left), k));
        return max;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/solution/395-zhi-shao-you-kge-zhong-fu-zi-fu-de-zui-chang-5/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

