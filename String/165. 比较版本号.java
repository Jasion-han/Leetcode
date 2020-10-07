#### [165. 比较版本号](https://leetcode-cn.com/problems/compare-version-numbers/) + 遍历最长字符串

难度：Median

### 解题思路

- 本题注意几个取特殊字符所需的条件，应用反斜杠来取到其字符本身，而不是直接取。

### 代码

```java
class Solution {
    public int compareVersion(String version1, String version2) {
        
        // 这里需要注意 . | \ 是需要反斜杠转译后才能取到
        // . 代表的是双引号内所有的字符，而不是指 . 本身
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
        }
        return 0;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/compare-version-numbers/solution/165-bi-jiao-ban-ben-hao-bian-li-zui-chang-zi-fu-ch/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

