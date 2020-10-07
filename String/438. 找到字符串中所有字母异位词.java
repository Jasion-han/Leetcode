#### [438. 找到字符串中所有字母异位词](https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/) + 滑动窗口问题

难度：Median

### 解题思路

本题是典型的 **窗口滑动 + 左右索引指针** 的算法

一开始还是先将字符串转换为字符数组，定义一个 `ans` 来接收结果

这里使用了两个数组 `needs` 和 `window` 来分别记录 **需要得到的元素** 和 **滑动窗口遍历到的** 元素

首先把目标数组 `arrP` 中有的元素都放入 `needs` 中，然后通过 **不断移动滑动窗口** 将目标元素的个数保存到 `window` 中

如果 `window` 数组中记录的元素个数超过了 `needs` 数组的元素个数，则开始 **移动左窗口** 慢慢减少多余的个数

最后把整个遍历过程中所有符合要求的 **左窗口索引** 放到 `ans` 中并返回即可。

### 代码

```java
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        char[] arrS = s.toCharArray();
        char[] arrP = p.toCharArray();
        
        // 接收最后返回的结果
        List<Integer> ans = new ArrayList<>();
        
        // 定义一个 needs 数组来看 arrP 中包含元素的个数
        int[] needs = new int[26];
        // 定义一个 window 数组来看滑动窗口中是否有 arrP 中的元素，并记录出现的个数
        int[] window = new int[26]; 
        
        // 先将 arrP 中的元素保存到 needs 数组中
        for (int i = 0; i < arrP.length; i++) {
            needs[arrP[i] - 'a'] += 1;
        }
        
        // 定义滑动窗口的两端
        int left = 0;
        int right = 0;
        
        // 右窗口开始不断向右移动
        while (right < arrS.length) {
            int curR = arrS[right] - 'a';
            right++;
            // 将右窗口当前访问到的元素 curR 个数加 1 
            window[curR] += 1;
            
            // 当 window 数组中 curR 比 needs 数组中对应元素的个数要多的时候就该移动左窗口指针 
            while (window[curR] > needs[curR]) {
                int curL = arrS[left] - 'a';
                left++;
                // 将左窗口当前访问到的元素 curL 个数减 1 
                window[curL] -= 1;            
            }
            
            // 这里将所有符合要求的左窗口索引放入到了接收结果的 List 中
            if (right - left == arrP.length) {
                ans.add(left);
            }
        }
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/20200321438median-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```





