#### [258. 各位相加](https://leetcode-cn.com/problems/add-digits/) +  O(n) 和 O(1) 时间复杂度

难度：Easy

### 解题思路

- 解 `1` 复杂度分析

  时间复杂度：`O(n)`，`n`为数字的位数

  空间复杂度：`O(1)`

- 解 `2` 复杂度分析

  时间复杂度：`O(1)`

  空间复杂度：`O(1)`

a的值..............   0 1 2 3 4 5 6 7 8 9
a % 9..............   0 1 2 3 4 5 6 7 8 0
(a-1) % 9.......   -1 0 1 2 3 4 5 6 7 8
(a-1) % 9 + 1...  0 1 2 3 4 5 6 7 8 9

### 代码

解法一：

```java
class Solution {
    public int addDigits(int num) {
        while (num >= 10) {
            num = num / 10 + num % 10;
        }
        return num;
    }
}
```

解法二：

```java
public int addDigits(int num) {
	return (num - 1) % 9 + 1;
}
```

