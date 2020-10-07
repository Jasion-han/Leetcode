#### [93. 复原IP地址](https://leetcode-cn.com/problems/restore-ip-addresses/) + 回溯 + 递归复原 ip 地址

难度：Median

### 解题思路

本题使用 **回溯和递归** 的思想复原 `ip` 地址

- 首先创建 `ans` 来接收复原后的所有 `ip` 地址，然后通过创建 **回溯方法 **进行筛选，最终返回 `ans`。

- 创建回溯方法体需要传入四个参数进行把控：1. 给定的数字字符串 `s`，2. 回溯过程中遍历到的位置 `pos`，3. 当前确定好的 `ip` 段的数量，4. 收集结果的 `ans`
- 考虑方法体出口：如果确定好 `4` 段并且遍历完整个 `s` ,就将 `tmp` 之间的段以 `.` 分隔开来放入 `ans`
- 接下来对 `s` 进行筛选,其中 **注意** 每段的长度最大为 `3` ,拆箱为 `int` 后的长度不超过 `255` ,起始位置不能为 `0`

- 控制好这些 **边界条件 **后就可以就可以正常的利用 **递归和回溯 **遍历字符串，具体可参考代码注释。

### 代码

```java
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return ans;
        }
        backtrack(s, ans, 0, new ArrayList<>());
        return ans;
    }
    // pos-当前遍历到 s 字符串中的位置，tmp-当前存放已经确定好的 ip 段的数量
    private void backtrack(String s, List<String> ans, int pos, List<String> tmp) {
        if (tmp.size() == 4) {
            // 如果此时 pos 也刚好遍历完整个 s
            if (pos == s.length()) {
                // join 用法：例如 [[255],[255],[111],[35]] -> 255.255.111.35
                ans.add(String.join(".", tmp));
            }
            // 否则直接返回
            return;
        }
        
        // ip 地址每段最多有三个数字
        for (int i = 1; i <= 3; i++) {
            // 如果当前位置距离 s 末尾小于 3 就不用再分段了，直接跳出循环即可。
            if (pos + i > s.length()) {
                break;
            }
            
            // 将 s 的子串开始分段
            String segment = s.substring(pos, pos + i);
            int val = Integer.valueOf(segment);
            // 剪枝条件：段的起始位置不能为 0，段拆箱成 int 类型的长度不能大于 255
            if (segment.startsWith("0") && segment.length() > 1 || (i == 3 && val > 255)) {
                continue;
            }
            
            // 符合要求就加入到 tmp 中
            tmp.add(segment);
            // 继续递归遍历下一个位置
            backtrack(s, ans, pos + i, tmp);
            // 回退到上一个元素，即回溯
            tmp.remove(tmp.size() - 1);
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/restore-ip-addresses/solution/2020041693medianhui-su-di-gui-fu-yuan-ip-di-zhi-by/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

