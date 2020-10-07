#### [380. 常数时间插入、删除和获取随机元素](https://leetcode-cn.com/problems/insert-delete-getrandom-o1/) + map,list,随机数

难度：Median

### 解题思路

- 题目要求是以相同概率获得一个集合中的随机数，那么支持 `random access` 的数据结构为 `Array, ArrayList`，所以我们用到 `ArrayList`

- 题目要求是 `O(1)` 的 `insert` 和 `remove`,所以通常只有用 `Hashtable` 来 check 是否存在这个元素，因此用到 `Hashmap data structure`

### 代码

```java
class RandomizedSet {
    
    // 创建 map,list,随机数
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random rdm;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rdm = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        // 每次插入都插入到 list 的最后面，所以是list.size()
        list.add(list.size(), val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        // 将要删除的元素和最后一个元素交换位置
        int lastElement = list.get(list.size() - 1);
        int idx = map.get(val);
        list.set(idx, lastElement);
        map.put(lastElement, idx);
        // 删除最后一个元素
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        // 以相同概率获得一个集合中的随机数
        return list.get(rdm.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

作者：Jasion_han
链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1/solution/380-chang-shu-shi-jian-cha-ru-shan-chu-he-huo-qu-9/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

