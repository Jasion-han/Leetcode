#### [347. 前 K 个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/) + HashMap 和 List 桶排序

难度：Median

### 解题思路

本题的最优解法是利用 **桶排序**

桶排序是把元素个数作为数组索引的,而出现在 `nums` 里每个元素至少有一个，所以要至少从桶 `1` 开始

因为 `bucket` 索引是从 `0` 开始的，所以其实多的是桶 `0`，桶 `0` 不可能有值。

首先创建一个 `Map` 记录数组中每个元素的频率

然后创建一个数组将元素 **按照频率** 升序存放在 `list` 中

定义 `i` 来接收每个元素的频率，并且元素就按照自己的 **频率作为数组的下标 ** 存储

最后对数组 **逆向** 求出前 `k`个高频率的元素，放入结果集 `ans` 即可。

### 代码

解法一：

```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 创建最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));
        for (int key : map.keySet()) {
            minHeap.offer(key);
            // 这里如果 size 大于 k 那就出队一个元素即堆中现存最小者,因为默认会保留较大元素
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        // 最后建立数组接受前 k 个元素,堆中所剩 k 个元素即为所求
        int[] ans = new int[k];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = minHeap.poll();
        }
        return ans;
    }
}
```

解法二：

```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        // 记录每个元素的频率
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // 按照 map 中元素的频率来创建数组，高频率的元素位于数组最后边
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key : map.keySet()) {
            // 定义 freq 来接收每个元素的频率值
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new LinkedList<>(); 
            }
            // 将对应频率的元素放入以频率为下标的数组中
            bucket[freq].add(key);
        }
        
        // 逆向找出前 k 高频率的元素
        List<Integer> ans = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && ans.size() < k; i--) {
            if (bucket[i] != null) {
                // 将当前频率下的元素放入结果集 ans 中
                ans.addAll(bucket[i]);
            }
        }
        // 注意题目要求返回的是 int[],如果是 List<Integer> 则直接返回 ans 即可
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/top-k-frequent-elements/solution/20200406347medianhashmaplisttong-pai-xu-by-jasion_/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

