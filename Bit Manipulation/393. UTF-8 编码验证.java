#### [393. UTF-8 编码验证](https://leetcode-cn.com/problems/utf-8-validation/) +  位运算 “与” 的运用

难度：Median

### 解题思路

阅读题目后就很清楚的知道该怎么判断每个字节是否符合规则，具体步骤看代码注释

### 代码

```java
class Solution {
    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) {
            return true;
        }
        
        // 如果在之后的遍历中没有返回 false 则最终会返回该值 true
        boolean isValid = true;
        
        for (int i = 0; i < data.length; i++) {
            if (data[i] > 255) {
                return false;
            }
            int numberOfByte = 0;
            // 0xxxxxxx, 1 byte, 128(10000000)
            if ((data[i] & 128) == 0) {
                numberOfByte = 1;
            // 110xxxxx, 2 bytes, 224(11100000), 192(11000000)
            } else if ((data[i] & 224) == 192) {
                numberOfByte = 2;
            // 1110xxxx, 3 bytes, 240(11110000), 224(11100000)
            } else if ((data[i] & 240) == 224) {
                numberOfByte = 3;
            // 11110xxx, 4 bytes, 248(11111000), 240(11110000)
            } else if ((data[i] & 248) == 240) {
                numberOfByte = 4;
            } else {
                return false;
            }
            for (int j = 1; j < numberOfByte; j++) {
                if ((i + j) >= data.length) {
                    return false;
                }
                // 192(11000000), 128(10000000)
                if ((data[i + j] & 192) != 128) {
                    return false;
                }
            }
            // 经过上面的 for 循环后跳到最后一个字节进行判断，因为之后在总的 for 循环里还会 + 1, 所以这里要 - 1
            i = i + numberOfByte - 1;
        }
        return isValid;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/utf-8-validation/solution/393-utf-8-bian-ma-yan-zheng-wei-yun-suan-yu-de-yun/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

