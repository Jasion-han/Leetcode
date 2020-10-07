#### [28. 实现 strStr()](https://leetcode-cn.com/problems/implement-strstr/) + 双指针法

难度: Easy

### 解题思路

双指针法遍历字符串

### 代码

```java
class Solution {
    public int strStr(String haystack, String needle) {        
        int sourceLen = haystack.length();
        int targetLen = needle.length();

        // 注意特判
        if(targetLen == 0){
            return 0;
        }

        // 若 target 长度大于 source，则不可能匹配
        if(targetLen > sourceLen){
            return -1;
        }

        for (int i = 0; i < sourceLen - targetLen + 1; i++) {
            // 定义 k 来与 target 进行挨个比对
            int k = i;
            for (int j = 0; j < targetLen; j++) {
                if (haystack.charAt(k) == needle.charAt(j)) {
                    // 最后一个字符匹配完成，输出答案
                    if (j == targetLen - 1) {
                        return i;
                    }
                    k++;
                }
                // 其中一个字符无法匹配，直接退出做下一次循环
                else {
                    break;
                }
            }
        }
        return -1;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/implement-strstr/solution/28shi-xian-strstrshuang-zhi-zhen-by-jasion_han/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

