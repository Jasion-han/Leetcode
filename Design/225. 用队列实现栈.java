#### [225. 用队列实现栈](https://leetcode-cn.com/problems/implement-stack-using-queues/) + 单队列反向存储

难度：Easy

### 解题思路

- 本题可以使用 **一个队列** 完成栈的操作
- 只需要让队列中 `size - 1` 个元素出队然后再入队即可完成反向操作。

### 代码

```java
class MyStack {

    Queue<Integer> queue;
    
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        // 对队列中的 size - 1 个元素进行再次入队操作实现反向存储
        for (int i = 1; i < queue.size(); i++) {
            queue.add(queue.remove());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

作者：Jasion_han
链接：https://leetcode-cn.com/problems/implement-stack-using-queues/solution/225-yong-dui-lie-shi-xian-zhan-dan-dui-lie-fan-xia/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

