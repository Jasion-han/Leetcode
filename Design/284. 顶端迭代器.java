#### [284. 顶端迭代器](https://leetcode-cn.com/problems/peeking-iterator/) +  创建迭代器 iter 和 next 指针共同操作

难度：Median

### 解题思路

根据标题和代码注释理解即可。

### 代码

```java
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    
    // 创建迭代器 iter 和 next 指针
    private Iterator<Integer> iter;
    private Integer next = null;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    iter = iterator;
        if (iter.hasNext()) {
            next = iter.next();
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer ans = next;
        next = iter.hasNext()? iter.next() : null;
        return ans;
	}
	
	@Override
	public boolean hasNext() {
	    return next != null;
	}
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/peeking-iterator/solution/284-ding-duan-die-dai-qi-chuang-jian-die-dai-qi-it/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

