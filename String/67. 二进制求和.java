#### [67. 二进制求和](https://leetcode-cn.com/problems/add-binary/) + append 后反转

难度：Easy

### 解题思路

- 本题需要注意是使用 `StringBuilder` 来依次添加从右边向左的累加和
- 最后需要注意剩余进位还应添加到其中

- 然后记得反转完成正向输出

### 代码

```java
class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            // 进位的值
            sum /= 2;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
            }
            // 每次加最右边的和
            sb.append(sum % 2);
            i--;
            j--;
        }
        // 如果最后有进位剩余，则直接加在 sb 后面
        if (sum / 2 != 0) {
            sb.append(1);
        }
        // 最后需要反转一下 sb
        return sb.reverse().toString();
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/add-binary/solution/67-er-jin-zhi-qiu-he-appendhou-fan-zhuan-by-jasion/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

