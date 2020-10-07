#### [6. Z 字形变换](https://leetcode-cn.com/problems/zigzag-conversion/) + 寻找周期规律

难度：Median

### 解题思路

本题通过排列规律，划分为 **周期间隔**

第一行两个元素之间即为一个周期，所以先计算周期数 `cycleLen`，通过 `StringBuilder` 可以修改字符串长度，使用 `append` 将每行元素依次添加到新的字符串数组 `ret` 中

这里将第一行和最后一行作为一类，其他行作为一类，分别 `append` 到 `ret` 中

时间复杂度：O(n)，虽然是两层循环，但第二次循环每次加的是 `cycleLen` ，无非是把每个字符遍历了 `1` 次，所以两层循环内执行的次数肯定是字符串的长度。

空间复杂度：O(n)，保存字符串。

### 代码

```java
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        // 可修改字符串长度
        StringBuilder ret = new StringBuilder();
        int n = s.length();
        // 周期大小
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            // 每次加一个周期
            for (int j = 0; j + i < n; j += cycleLen) { 
                // 将第 1 行和最后 1 行加进去
                ret.append(s.charAt(j + i));
                // 除去第 1 行和最后 1 行
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n){ 
                    // 加入其他行元素
                    ret.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        // 最后返回字符串格式
        return ret.toString();
    }
}



作者：Jasion_han
链接：https://leetcode-cn.com/problems/zigzag-conversion/solution/202003106median-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

