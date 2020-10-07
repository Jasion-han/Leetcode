#### [12. 整数转罗马数字](https://leetcode-cn.com/problems/integer-to-roman/) + 巧用双数组寻找对应整数

难度：Median

### 解题思路

本题和 `13` 题的题目完全相反

整数转罗马数字首先是要建立 **两个对应的数组**，依次从大的整数开始判断是否符合，则将对应的罗马数字加入到 `ans` 中

每加进去一个罗马数字，都要记得用 `num` 减去 `nums` 数组里面的整数，依次从大的值向小的值进行判断，直到遍历完整数数组 `nums`

### 代码

```java
class Solution {
    public String intToRoman(int num) {
        int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int index = 0;
        StringBuilder ans = new StringBuilder();
        // 遍历整个 nums 数组
        while(index < 13){
            // 从一开始的最大值开始比较
            while(num >= nums[index]){
                // 如果满足 nums 里的数值，就将 romans 里对应位置的字母加进去
                ans.append(romans[index]);
                num -= nums[index];               
            }
            index++;
        }
        return ans.toString();
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/integer-to-roman/solution/2020031312median-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



