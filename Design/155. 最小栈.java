#### [155. 最小栈](https://leetcode-cn.com/problems/min-stack/) +  有辅助栈 和 无辅助栈双解法

难度：Easy

### 解题思路

- 解法一用到了辅助栈
- 解法二没有用辅助栈

### 代码

解法一：

```java
class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> min_stack;

    public MinStack() {
        stack = new Stack<>();
        min_stack = new Stack<>();
    }
    public void push(int x) {
        stack.push(x);
        // 如果一开始 min_stack 为空或者有更小的元素出现,就将其入 min 栈
        if(min_stack.isEmpty() || x <= min_stack.peek())
            min_stack.push(x);
    }
    public void pop() {
        // 当出栈元素和 min_stack 栈顶元素值相等,说明是最小值可以出栈
        if(stack.pop().equals(min_stack.peek()))
            min_stack.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return min_stack.peek();
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```



解法二：

```java
class MinStack {

    Stack<Integer> stack;
    int min;
    
    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if (x <= min) {
            // 先放进去 min 再放 x,那么栈顶元素就是最小值
            stack.push(min);
            min = x;
        }
        // 正常入栈
        stack.push(x);
    }
    
    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

作者：Jasion_han
链接：https://leetcode-cn.com/problems/min-stack/solution/155-zui-xiao-zhan-you-fu-zhu-zhan-wu-fu-zhu-zhan-s/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

