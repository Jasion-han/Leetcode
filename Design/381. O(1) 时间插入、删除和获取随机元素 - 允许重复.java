#### [381. O(1) 时间插入、删除和获取随机元素 - 允许重复](https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed/) + map, list, 随机数

难度：Hard

### 解题思路

- 本题是 380 的变形问题，给定的元素有了重复元素，所以我们需要在 `map` 中以 `set` 来存储对应的值。

需要注意的几点：

- `iterator.next()` 是从第一个开始依次的输出下一个，迭代器和数据结构中的链表一样，有个`header` 指针，`header -> next()` 就是链表中第一个元素

```
如下所示：
    1   2   3   4   
|

当读取一次 iterator.next(); 后，指针如下

1   2   3   4   
|

（其中|表示指针所指位置）
```

- `list.set()` 方法直观上根据方法名可以理解为设置 `list` 中某个位置的元素。但需要注意的是，该方法本质上是一种替换操作，即要设置某个位置上的元素，这个位置在设置前必须有元素，否则会抛出异常

### 代码

```java
class RandomizedCollection {
    
    // 创建 map list 随机数
    private Map<Integer, Set<Integer>> map;
    private List<Integer> list;
    private Random rdm;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rdm = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = map.containsKey(val);
        if (!contain) {
            map.put(val, new HashSet<>());
        }
        map.get(val).add(list.size());
        list.add(val);
        // 如果已经存在还要插入同一个元素则返回 false
        return !contain;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        // .iterator().next() 表示移动指针依次取出里面的元素
        int index = map.get(val).iterator().next();
        // map 中对应 val 的个数减一
        map.get(val).remove(index);
        // 如果减为了 0 则移除该元素
        if (map.get(val).size() == 0) {
            map.remove(val);
        }
        // 标记 list 中移除的最后一个值
        int lastVal = list.remove(list.size() - 1);
        // 如果 index 还未走到 list 的末尾,就和最后一个元素交换位置,即每次移除的都是最后一个位置从而实现 O(1)
        if (index != list.size()) {
            list.set(index, lastVal);
            map.get(lastVal).remove(list.size());
            map.get(lastVal).add(index);
        }
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rdm.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

作者：Jasion_han
链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed/solution/381-o1-shi-jian-cha-ru-shan-chu-he-huo-qu-sui-ji-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

