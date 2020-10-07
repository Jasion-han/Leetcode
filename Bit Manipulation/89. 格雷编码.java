#### [89. 格雷编码](https://leetcode-cn.com/problems/gray-code/) + 右移再异或，记忆性题目

难度：Median

### 解题思路

如题。

### 代码

```java
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        // 因为格雷码长度是 2 的 n 次方
        for (int i = 0; i < (1 << n); i++) {
            // 通过除 2 后再异或即可完成编码过程
            ans.add(i ^ (i >> 1));
        }
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/gray-code/solution/89ge-lei-bian-ma-you-yi-zai-yi-huo-ji-yi-xing-ti-m/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

