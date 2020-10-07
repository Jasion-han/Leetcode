#### [344. 反转字符串](https://leetcode-cn.com/problems/reverse-string/) + 头尾双指针法

难度：Easy

### 解题思路

- 本题思路很简单
- 通过 **双指针法** 依次遍历整个数组
- 用 `while` 循环控制边界，再依次交换数据即可。

### 代码

```java
class Solution {
    public void reverseString(char[] s) {
        if (s== null || s.length == 0) {
            return;
        }
        // 定义左右指针
        int left = 0;
        int right = s.length - 1;
        // 定义临时交换变量 temp
        char temp;
        while (left < right) {
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;  
            left++;
            right--;
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/reverse-string/solution/20200320344easy-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

