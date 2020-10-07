#### [38. 外观数列](https://leetcode-cn.com/problems/count-and-say/) + StringBuilder

难度：Easy

### 解题思路

例如：`1211`
其解法是： 当 `1 -> 2` 时 记录原有的 `1` 个 `1`         `11`
当 `2 -> 1` 时，记录原有的 `1` 个 `2`                        `1112`
当 `1 -> 1` 时，记录 `1` 个 `1` 
最后又有一个 `1` ，用 `count++`，即为 `2` 个 `1`     `111221`

### 代码

```java
class Solution {
    public String countAndSay(int n) {
        if (n < 1) {
            return "";
        }
        // 最开始设为 1
        String str = "1";
        // 这里从下标为 1 的位置开始遍历
        for (int i = 1; i < n; i++) {
            char pre = ' ';
            int count = 0;
            StringBuilder sb = new StringBuilder();
            // 例如: 1211 
            for (int index = 0; index < str.length(); index++) {
                // 这里是上面后两个1的情况以及最初的情况
                if (str.charAt(index) == pre || pre == ' ') {
                    count++;
                } else {
                    // 这里是从第一个1->2,以及2->1遍历的过程
                    sb.append(count + Character.toString(pre));
                    count = 1;
                }
                // pre 指向上一轮指向过的 index
                pre = str.charAt(index);
            }
            // 这里是加上后面两个 1 的情况
            sb.append(count + Character.toString(pre));
            str = sb.toString();
        }
        return str;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/count-and-say/solution/38-wai-guan-shu-lie-stringbuilder-by-jasion_han/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

