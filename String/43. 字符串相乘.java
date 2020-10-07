#### [43. 字符串相乘](https://leetcode-cn.com/problems/multiply-strings/) + 进位拼接

难度：Median

### 解题思路

注意进位与长度

### 代码

```java
class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "0";
        }
        // 定义相乘后的最大长度，例如 9 * 9 = 81,长度为两者长度之和
        int[] digits = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // 一开始 p1 指向十位，p2 指向个位，逐个往前移动
                int p1 = i + j;
                int p2 = i + j + 1;
                // 每次两数相乘后再加上进位值
                int sum = product + digits[p2];
                digits[p1] += sum / 10;
                digits[p2] = sum % 10;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int digit : digits) {
            // 如果当前数字不为 0 或者 ans 长度不为 0 就把遍历到的数字加入 ans
            if (digit != 0 || ans.length() != 0) {
                ans.append(digit);
            }
        }
        return ans.length() == 0 ? "0" : ans.toString();
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/multiply-strings/solution/43-zi-fu-chuan-xiang-cheng-jin-wei-pin-jie-by-jasi/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

