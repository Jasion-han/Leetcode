#### [76. 最小覆盖子串](https://leetcode-cn.com/problems/minimum-window-substring/) + 滑动窗口问题

难度：Hard

### 解题思路

本题难度为 `hard`，思路参考 `438` 题，基本一致

这道题和 `438` 题的区别在于要不断移动找出 **最小的子串** ，所以判断有些复杂

代码注释很好的解释了做题思路，最好在纸上画出一串字符一步一步的观察变化，最后就会迎刃而解了。

### 代码

```java
class Solution {
    public String minWindow(String s, String t) {
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        
        // 创建两数组分别存储需要的元素和已经遍历到的元素
        int[] needs = new int[128];
        int[] window = new int[128];
        
        // 遍历 arrT 数组,将目标元素及其个数存到 needs 数组中
        for (int i = 0; i < arrT.length; i++) {
            needs[arrT[i]]++;
        }
        
        int left = 0;
        int right = 0;
        // 记录满足要求的字符数
        int count = 0;
        // 接收结果
        String ans = "";
        // 定义最小值
        int min = Integer.MAX_VALUE;
        
        while (right < arrS.length) {
            int curR = arrS[right];
            window[curR]++;
            // 当 window 数组存放个数不超过 needs 数组时计数 + 1
            if (needs[curR] > 0 && needs[curR] >= window[curR]) {
                count++;
            }
            // 当计数的个数和 arrT 数组长度相等时
            while (count == arrT.length) {
                
                // 更新最小子串
                if (min > (right - left) + 1) {
                    min = (right - left) + 1;
                    ans = s.substring(left, right + 1);
                }  
                
                int curL = arrS[left];
                
                // 如果 needs 数组里有 curL 且窗口内也有,则去掉 curL 即计数--
                // 其目的是为了右移 left 继续寻找更小距离的目标结果
                if (needs[curL] > 0 && needs[curL] >= window[curL]) {
                    count--;
                }
                
                window[curL]--;
                left++;
            }
            right++;
        }
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/minimum-window-substring/solution/2020032176hard-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

