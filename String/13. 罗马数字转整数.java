#### [13. 罗马数字转整数](https://leetcode-cn.com/problems/roman-to-integer/) + 分情况遍历罗马数字

难度：Easy

### 解题思路

本题是将罗马数字转成整数字

需要进行 `for` 循环逐个遍历，使用字符转数字的功能函数用 `switch - case` 语句将罗马数字转成数字

其中要区分类似 `IV` , `VI` 的判断条件，前者是需要 **减一下**，后者则直接 **相加** 即可

### 代码

```java
class Solution {
    public int romanToInt(String s) {
        int n = s.length();
        int sum  = 0;
        // 记录第一个值
        int preNum = getValue(s.charAt(0));
        // 从第二个数字开始往后遍历
        for(int i = 1; i < n; i++){
            int num = getValue(s.charAt(i));
            // 像 IV, IX, XL 是需要后一个减前一个
            if(preNum < num){
                sum -= preNum;
            // 像 VI, XI, LX 是前一个直接加上后一个
            }else{
                sum += preNum;
            }
            // 更新前一个指向，不断往后遍历
            preNum = num;
        }
        // for 循环里面没有算上最后一个值，这里需要加一下
        sum += preNum;
        return sum;
    }
    
    // 字符转数字 功能函数
    private int getValue(char ch){
        switch(ch){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : return 0;
        } 
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/roman-to-integer/solution/2020031313easy-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

