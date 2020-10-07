#### [202. 快乐数](https://leetcode-cn.com/problems/happy-number/) + 巧用 HashSet 进行循环变换

难度：Easy

### 解题思路

本题主要思路就是定义变换的方法，**判断是否有重复数字出现**

首先定义 `Set` 先将初始值保存，然后通过 `while` 控制该数字是否能转换出 `1`，进而判断是否是快乐数

定义一个 `loop` 方法接收每次变换后的数字并返回给主方法进行审核，若结果不重复且最后为 `1` 则说明是快乐数，否则不是

### 代码

```java
class Solution {
    public boolean isHappy(int n) {
        // 定义 HashSet 存放每次平方后的数字
        Set<Integer> set = new HashSet<>();
        set.add(n);
        // 如果变换的结果不为 1 就一直变换下去
        while (n != 1) {
            // 开始循环变换
            n = loop(n);
            // 每次变换后判断是否有重复数字，有则代表将会无限循环，没有就添加至Set
            if ( set.contains(n) ) {
                return false;
            }
            set.add(n);
        }
        return true;
    }  
    
    // 用于循环变换之前的数字
    private int loop (int n) {
        // 定义变换后新的数字
        int sum = 0;
        while (n != 0) {                
            int num = n % 10;
            n /= 10;
            sum += num * num;
        }
        return sum;
    }            
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/happy-number/solution/20200323202easy-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



