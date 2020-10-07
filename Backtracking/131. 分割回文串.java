#### [131. 分割回文串](https://leetcode-cn.com/problems/palindrome-partitioning/) + 递归+回溯分割回文串

难度：Median

### 解题思路

本题和 `93` 题很相似，基本思想是一致的

- 这里的 **中心思想 **就是如何寻找回文串，并将其传入数组中去

- 在回溯方法体内，我们调用 `isPalindrome` 方法找到回文串并将其放入 `tmp` 数组中，接着递归遍历后面的元素
- 每遍历完当前元素就 **回退 **上一个继续遍历即回溯
- 等遍历完所有的返回 `ans` 即可。

### 代码

```java
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return ans;
        }
        // 回溯
        back(s, 0, new ArrayList<>(), ans);
        return ans;
    }
    
    // 创建回溯方法体，中间两参数分别代表当前位置和存放符合要求的分割数组
    private void back(String s, int pos, List<String> tmp, List<List<String>> ans) {
        int len = s.length();
        if (pos == len) {
            // 这里要传入初始化的 tmp，以免因 tmp 发生改变而影响结果
            ans.add(new ArrayList<>(tmp));
            return;
        } 
        for (int i = pos; i < len; i++) {
            if (pos == len) {
                break;
            }
            String cur = s.substring(pos, i + 1);
            // 如果当前遍历到的子串是回文串
            if (isPalindrome(cur) {
                // 就将其加入到 tmp 中
                tmp.add(cur);
                // 递归遍历下一个
                back(s, i + 1, tmp, ans);
                // 回退到上一个元素继续（回溯）
                tmp.remove(tmp.size() - 1);
            }            
        }
    }
    
    // 判断是否是回文
    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/palindrome-partitioning/solution/20200416131mediandi-gui-hui-su-fen-ge-hui-wen-chua/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

