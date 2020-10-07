#### [300. 最长上升子序列](https://leetcode-cn.com/problems/longest-increasing-subsequence/) +  dp，二分法

难度：Median

### 解题思路

巧用 `dp` + 二分搜索

### 代码

解法一：

```java
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        
        int len = 0;
        for (int num : nums) {
            int index = Arrays.binarySearch(dp, 0, len, num);
            if (index < 0) {
                index = -(index + 1);
            }
            
            dp[index] = num;
            
            if (index == len) {
                len++;
            }
        }
        return len;
    }
}
```

解法二：

```java
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            int p = nums[i];

            // 二分法
            int left = 0, right = len;
            while (left < right) {
                int mid = (left + right) / 2;
                if (dp[mid] > p) {
                    right = mid;
                } else if (dp[mid] < p) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            if (left == len) len++;
            dp[left] = p;
        }
        return len;
    }
}
```

解法三：

```java
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }
}
// Runtime: 2 ms

作者：Jasion_han
链接：https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/300-zui-chang-shang-sheng-zi-xu-lie-dper-fen-fa-by/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

