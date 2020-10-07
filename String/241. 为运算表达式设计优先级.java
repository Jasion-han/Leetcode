#### [241. 为运算表达式设计优先级](https://leetcode-cn.com/problems/different-ways-to-add-parentheses/) +  递归，分治法

难度：Median

### 解题思路

- 此题需要考虑分割的位置
- 运用分治处理每个运算符分割的两部分，每次的步骤用递归直接带入处理即可
- 创建了 `3` 个函数帮助解决问题：
  找运算符
  计算运算符左右两个元素
  判断是否找到了这三种运算符

### 代码

```java
class Solution {
    public List<Integer> diffWaysToCompute(String input) {  
        List<Integer> ans = new ArrayList<>();
        if (input == null || input.length() == 0) {
            return ans;
        }
        
        // 定义寻找运算符的索引
        int divIndex = findNextOperator(input, 0);
        // 如果运算符索引达到了字符串尾（出口情况）
        if (divIndex == input.length()) {
            ans.add(Integer.parseInt(input));
            return ans;
        }
        
        // 若有多个运算符，则挨个遍历
        while (divIndex < input.length()) {
            // 取出当前运算符
            char c = input.charAt(divIndex);
            List<Integer> leftNums = diffWaysToCompute(input.substring(0, divIndex));
            List<Integer> rightNums = diffWaysToCompute(input.substring(divIndex + 1));
            for (int left : leftNums) {
                for (int right : rightNums) {
                    ans.add(caculate(left, right, c));
                }
            }
            // 运算符索引移动到下一个运算符位置
            divIndex = findNextOperator(input, divIndex + 1);
        }
        return ans;
    }
    
    // 带上运算符进行 + - * 运算
    private int caculate(int left, int right, int operator) {
        int ans = 0;
        switch(operator) {
            case '+' : ans = left + right;
                break;
            case '-' : ans = left - right;
                break;
            case '*' : ans = left * right;
                break;
        }
        return ans;
    }
    
    // 找下一个运算符
    private int findNextOperator(String input, int start) {
        int index = start;
        while (index < input.length() && !isOperator(input.charAt(index))) {
            index++;
        }
        return index;
    }
    
    // 判断是否为以下三种运算符
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*';
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/different-ways-to-add-parentheses/solution/241-wei-yun-suan-biao-da-shi-she-ji-you-xian-ji-di/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

