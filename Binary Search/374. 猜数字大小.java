#### [374. 猜数字大小](https://leetcode-cn.com/problems/guess-number-higher-or-lower/) + 二分法

难度：Easy

### 解题思路

本题没有使用经常写的写法，这里用到最普通的二分写法，需要注意 `mid` 的 `+1` 或者 `-1`

### 代码

```java
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        
        // 二分法,题目要求从1~n
        int left = 1;
        int right = n ;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int tmp = guess(mid);
            if (tmp == 0) {
                return mid;
            // 说明猜小了，应该往大了猜
            } else if (tmp == 1) {
                left = mid + 1;
            // 说明猜大了，应该往小了猜
            } else if (tmp == -1) {
                right = mid - 1;
            }
        }
        // 没找到返回 -1
        return -1;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower/solution/374-cai-shu-zi-da-xiao-er-fen-fa-by-jasion_han/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

