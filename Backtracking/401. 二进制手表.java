#### [401. 二进制手表](https://leetcode-cn.com/problems/binary-watch/) + 暴力循环 or 递归回溯

难度：Easy

### 解题思路

本题提供 **两种** 算法思路：

第一种是：暴力循环

- 直接对 **时钟** 和 **分钟** 数进行 `for` 循环遍历，判断 **两者之和 **是否和 `sum` 一样，将满足要求的放入结果集 `ans` 中（注意转换格式）

第二种是：递归回溯法

- 用到的回溯法主要是遍历每个数字，最后回退到上一步依次找出 **目标值** 放入 `time` 数组

- 然后定义 **时钟数组 **和 **分钟数组 **来存储当前 **亮着的数字之和**，然后判断是否符合正常的时间，再加入 `ans` 即可。

### 代码

解法一：

```java
class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> ans = new ArrayList<>();
        // 循环将时和分遍历到的数字相加看是否和 num 一样
        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute< 60; minute++) {
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == num) {
                    ans.add(String.format("%d:%02d", hour, minute));
                }
            }
        }
        return ans;
    }
}
```

解法二：

```java
class Solution {
    private List<String> ans = new ArrayList<>();
    public List<String> readBinaryWatch(int num) {
        if (num < 0) {
            return ans;
        }
        // 回溯          这里创建一个大小为 10 的数组存放表上的时分数
        back(num, 0, new int[10]);
        return ans;
    }
    
    private void back(int num, int index, int[] time) {
        // 如果找到某个时刻刚好等于 num 的数
        if (num == 0) {
            // 定义 hour 来存储此时亮着的时钟数之和
            int hour = time[0] + 2 * time[1] + 4 * time[2] + 8 * time[3];
            // 定义 minute 来存储此时亮着的分钟数之和
            int minute = time[4] + 2 * time[5] + 4 * time[6] + 8 * time[7] + 16 * time[8] + 32 * time[9];
            // 如果是正常的时间就放入 ans
            if (hour < 12 && minute < 60) {
                ans.add(String.format("%d:%02d", hour, minute));
            }
            return;
        }
        // 回溯
        for (int i = index; i < time.length; i++) {
            // 开始时将该位置置为 1
            time[i] = 1;
            back(num - 1, i + 1, time);
            // 之后再将其置为 0 以达到回溯的效果
            time[i] = 0;
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/binary-watch/solution/20200423401easybao-li-xun-huan-or-di-gui-hui-su-by/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

