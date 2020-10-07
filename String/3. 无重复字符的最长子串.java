#### [3. 无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/) + Map和滑动窗口的结合

难度：Median

### 解题思路

窗口滑动案例

通过 `map` 来开辟一个窗口，一开始左侧保持不动，通过右侧窗口不断右移来寻找目标子串
如果遇见相同元素就需要将左侧位置移动到 `map` 中已经存在的相同元素的下一个位置作为新的起始位置，直到右侧窗口到达字符串结尾

### 代码

解法一：

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length(),ans=0;
        int start=0;
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0; i<n; i++){
            //看map中是否已经存在和当前i所指相同的数据
            if(map.containsKey(s.charAt(i))){
                //将map中已经存在的i的下一个位置作为起始位置
                start=Math.max(start,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            ans=Math.max(ans,i-start+1);//更新子串长度
        }
        return ans;
    }
}
```

解法二：

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        // 滑动窗口思想
        int left = 0;
        int right = 0;
        int n = s.length();
        
        boolean[] used = new boolean[128];
        int max = 0;
        
        while (right < n) {
            if (used[s.charAt(right)] == false) {
                used[s.charAt(right)] = true;
                right++;
            } else {
                max = Math.max(max, right - left);
                while (left < right && s.charAt(left) != s.charAt(right)) {
                    used[s.charAt(left)] = false;
                    left++;
                }
                left++;
                right++;
            }
        }
        max = Math.max(max, right - left);
        return max;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/202003063medium-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

