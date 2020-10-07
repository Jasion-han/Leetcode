#### [354. 俄罗斯套娃信封问题](https://leetcode-cn.com/problems/russian-doll-envelopes/) +  二分法，排序

难度：Hard

### 解题思路

- 本题和 `300` 很相似，主要理解如何以二分法进行比较确定问题。

- 这一题首先用 `lambda` 表达式对**宽**进行排序，而后再单独对**高**进行二分搜索找到目标元素

### 代码

解法一：

```java
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length != 2) {
            return 0;
        }
        // 将 w (宽) 按升序排序
        Arrays.sort(envelopes, (a, b) ->{
            // 升序
            if (a[0] != b[0]) {
                return a[0] - b[0];
            // 降序
            } else {
                return b[1] - a[1];
            }
        });
        
        int[] sortedArray = new int[envelopes.length];
        int size = 0;
        for (int[] env : envelopes) {
            // 取出 h (高) 进行比较
            int num = env[1];
            // 二分法
            int left = 0;
            int right = size;
            while (left != right) {
                int mid = left + (right - left) / 2;
                if (sortedArray[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            // left 与 right 相等,直接放入 num 即可
            sortedArray[left] = num;
            // 如果 left 走到了 size,说明需要扩大 size
            if (left == size) {
                size++;
            }
        }
        return size;
    }
}
```

解法二：

```java
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int maxL = 0;
        int[] dp = new int[envelopes.length];
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        
        for (int[] env : envelopes) {
            int left = 0;
            int right = maxL;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (dp[mid] < env[1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            dp[left] = env[1];
            if (left == maxL) {
                maxL++;
            }
        }
        return maxL;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/russian-doll-envelopes/solution/354-e-luo-si-tao-wa-xin-feng-wen-ti-er-fen-fa-pai-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

