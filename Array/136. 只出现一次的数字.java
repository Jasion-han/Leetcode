#### [136. 只出现一次的数字](https://leetcode-cn.com/problems/single-number/) + 异或运算的优化方法

难度：Easy

### 解题思路

本题给了两种解法

第一种是按照 **HashMap 将元素值为 1 的找出来。第二种是按照 异或运算** 减少到空间复杂度为 `O(1)`

常规思路使用 `HasnMap` 是很容易得出结果的，但在这里巧妙使用异或运算却能够极大地优化空间复杂度。

### 代码

解法一：

```java
class Solution {
    public int singleNumber(int[] nums) {        
        //解法一：使用 HashMap 记录元素出现的个数        
        HashMap<Integer,Integer> record = new HashMap<>();
        for (int num : nums) {
            if ( !record.containsKey(num) ) {
                record.put(num, 1);
            } else {
                record.put(num, record.get(num) + 1);
            }
        }
        
        for (int num : record.keySet()) {
            int cnt = record.get(num);
            if (cnt == 1) {
                return num;
            }
        }
        return -1;
    }
}
```

解法二：

```java
class Solution {
    public int singleNumber(int[] nums) {        
        // 解法二：使用异或运算
        int ans = 0;
        for (int num : nums) { 
            // 依据相同为 0，相异为 1的原理
            // 如果没有与之相重复的元素，也就是相异，则会返回 1，否则返回 0
            // 将所有数字按照顺序进行异或运算，最后剩下的结果就是那个唯一的数字
            ans ^= num;            
        }
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/single-number/solution/20200322136easy-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

