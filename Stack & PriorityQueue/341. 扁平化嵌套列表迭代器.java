#### [341. 扁平化嵌套列表迭代器](https://leetcode-cn.com/problems/flatten-nested-list-iterator/) + 用栈做设计

难度：Median

### 解题思路

回头再来做，发现用 **栈** 来取元素比较方便，具体见解法二

### 代码

解法一：

```java
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private List<Integer> list;
    private int index;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        list = integerIterator(nestedList);
        index = -1;
    }

    @Override
    public Integer next() {
        if (this.hasNext()) {
            return list.get(++index);
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        if (index + 1 < list.size()) {
            return true;
        }
        return false;
    }
    
    private static List<Integer> integerIterator(List<NestedInteger> nestedIntegerList) {
        List<Integer> list = new ArrayList<>(nestedIntegerList.size());
        for (NestedInteger tmp : nestedIntegerList) {
            if (tmp.isInteger()) {
                list.add(tmp.getInteger());
            } else {
                list.addAll(integerIterator(tmp.getList()));
            }
        }
        return list;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
```

解法二:

```java
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        // 先让后面的元素压栈,则栈顶元素就是前面的元素
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            // 判断栈顶元素是否为数字
            NestedInteger cur = stack.peek();
            if (cur.isInteger()) {
                return true;
            }
            // 如果不是数字说明是 list 则将其出栈
            stack.pop();
            // 出栈后将 list 里面的数字完成一次倒序入栈而后正向出栈的过程
            for (int i = cur.getList().size() - 1; i >= 0; i--) {
                stack.push(cur.getList().get(i));
            }
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

作者：Jasion_han
链接：https://leetcode-cn.com/problems/flatten-nested-list-iterator/solution/20200403341median-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

