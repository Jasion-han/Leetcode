#### [451. 根据字符出现频率排序](https://leetcode-cn.com/problems/sort-characters-by-frequency/) + 使用 pq 构建堆

难度：Median

### 解题思路

本题给出两种思路

- 第一种是按照**字符频率**排序，在排序的时候需要传入**自定义比较器** `Comparator` 的实现对象

- 第二种是使用**优先队列**依据先进先出的特点将高频次的元素首先进队，那么出队的元素也会按照从高到低的顺序排序

具体实现参考代码注释即可。

### 代码

解法一：

```java
class Solution {
    public String frequencySort(String s) {
        
        // 使用 Map 先将字符串元素存放进来
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!map.containsKey(c) ) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        
        // 定义 比较器 Comparator  进行本题中的从大频次到小频次排序
        Comparator<Character> cmp = new Comparator<Character>(){
            @Override
            public int compare(Character o1, Character o2){
                // 如果元素对应个数一样，则按照字典顺序返回
                if (map.get(o2) - map.get(o1) == 0) {
                    return o1.compareTo(o2);
                }
                // 否则就按照元素个数从大到小返回
                return map.get(o2) - map.get(o1);
            }
        };
        
        // 先把字符串 s 中的元素放入 arrS 数组中
        Character[] arrS = new Character[s.length()];
        for (int i=  0; i < s.length(); i++) {
            arrS[i] = s.charAt(i);
        }
        
        // 然后使用比较器 cmp 规则进行"大->小"排序
        Arrays.sort(arrS, cmp);
        
        // 定义可变字符串 StringBuilder，将排好序的元素按顺序存入
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(arrS[i]);
        }
        
        // 最后转换成字符串形式返回
        return sb.toString();
    }
}
```

解法二：

```java
class Solution {
    public String frequencySort(String s) {
        // 字符串转字符数组后存入 map
        char[] cs = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (char n : cs) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        // 使用优先队列打包存储键值对 entry                                  这里用到 lamda 表达式
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((o1, o2) ->{
            // 如果两个元素的个数相等就按字典顺序返回
            if (o1.getValue().equals(o2.getValue()) ) {
                // 就按字典顺序返回
                return o1.getKey().compareTo(o2.getKey());
            }
            // 不相等就按频次从高到低返回
            return o2.getValue() - o1.getValue();
        });
        
        // 将排好序的 entry 打包送进队列
        for (Map.Entry<Character,Integer> entry : map.entrySet() ) {
            pq.offer(entry);
        }
        
        // 然后根据队列先进先出的特点从末尾依次取出元素放入可变字符串 StringBuilder 中
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty() ) {
            // 将打包的 entry 从末尾挨个取出
            Map.Entry<Character,Integer> ans = pq.poll();
            // 然后放入 StringBuilder 的对象 sb 中
            for (int i = 0; i < ans.getValue(); i++) {
                sb.append(ans.getKey());
            }
        }
        return sb.toString();
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/sort-characters-by-frequency/solution/20200324-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

