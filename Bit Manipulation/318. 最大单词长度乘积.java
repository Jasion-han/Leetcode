#### [318. 最大单词长度乘积](https://leetcode-cn.com/problems/maximum-product-of-word-lengths/) + 位运算 “或” “与” 的使用

难度：Median

### 解题思路

本题运用位运算中的 **“或”** **“与”**

该解释如下

```
val |= 1 << (words[i].charAt(j) - 'a');

     1 << 0  00001 = 1  a
     1 << 1  00010 = 2  b
     1 << 2  00100 = 4  c
     1 << 3  01000 = 8

     abc = 00111 = 7   ab = 00011 = 3
```

### 代码

```java
class Solution {
    public int maxProduct(String[] words) {
        int ans = 0;
        int[] bytes = new int[words.length];
        // 遍历数组中的每个字符串
        for (int i = 0; i < words.length; i++) {
            int val = 0;
            // 遍历字符串中的每个字母
            for (int j = 0; j < words[i].length(); j++) {
                // 1 << 3 代表 1 * 2 的 3 次方
                // 将字母转换成 0 1 字节码存储
                // 但因为是 0 1 存储,所以不能用 + 而用 | 来求和
                val |= 1 << (words[i].charAt(j) - 'a');
            }
            // 将转换后的字节码放到对应的 bytes 数组中
            bytes[i] = val;
        }
        
        for (int i = 0; i < bytes.length; i++) {
            for (int j = i + 1; j < bytes.length; j++) {
                // 因为是用 0 1 存储,所以不能用 && 而用 & 来判断是否有重复字母
                // 如果有重复字母,那么重复位置字节码都为 1,而经过 & 后值为 1 不是 0,则不能算作目标字符串
                // 当两个字符串没有相同的字母时，二进制数 “与” 的结果为 0
                if ((bytes[i] & bytes[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/maximum-product-of-word-lengths/solution/318-zui-da-dan-ci-chang-du-cheng-ji-wei-yun-suan-h/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

