#### [273. 整数转换英文表示](https://leetcode-cn.com/problems/integer-to-english-words/) +  递归法

难度：Hard

### 解题思路

- 先把数字以三个为一组分成若干小组

- 在每个小组里单独处理三位数

  1）仅一个字符串表示的两位数：`0` ~ `19`

  2）需要两个字符串表示的两位数：`20` ~ `99`

  3）三位数（百位以上的数 + 后面两位）：例如 `345 -> 3 + “Hundred” + 4 + 5`

### 代码

```java
class Solution {
    
    private final String[] LESSTHAN = {"", "One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    private final String[] TENS = {"", "Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    private final String[] THOUSAND = {"", "Thousand", "Million", "Billion", "Trillion"};
    
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        int i = 0;
        String ans = "";
        // 将数字 3 位 3 位的拆分处理（即千位）
        while (num > 0) {
            if (num % 1000 != 0) {
                ans = helper(num % 1000) + THOUSAND[i] + " " + ans;
            }
            i++;
            num /= 1000;
        }
        // 去除空格
        return ans.trim();
    }
    
    private String helper(int n) {
        if (n == 0) {
            return "";
            // 1 ~ 19
        } else if (n < 20) {
            return LESSTHAN[n] + " ";
            // 20 ~ 99
        } else if (n < 100) {
            return TENS[n / 10] + " " + helper(n % 10);
            // 100 ~ 999
        } else {
            return LESSTHAN[n / 100] + " Hundred " + helper(n % 100);
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/integer-to-english-words/solution/273-zheng-shu-zhuan-huan-ying-wen-biao-shi-di-gui-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

