#### [350. 两个数组的交集 II](https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/) + 巧用 HashMap

难度：Easy

### 解题思路

本题和 `349` 题换汤不换药，上一题的要求需要用 `Set` 来存放元素，而本题则是用的 `Map`

思路其实和 `349` 基本一致，**区别** 就是需要用 `Map` 既存放元素本身，还要存放其个数值（**重复元素也要计算在内**）

剩下的就是一样的了，具体细节参考 `349` 题解题思路或者本题代码注释（很详细了）

### 代码

```java
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        // 创建 list 来存放交集数字
        List<Integer> list = new ArrayList<>();
        // 先将 nums1 中数字放入 map
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }
        // 再对比放入 nums2 中的数字
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                // 两数组有相同的就放入 list 中
                list.add(nums2[i]);
                // 对应数字的值要 -1
                map.put(nums2[i], map.get(nums2[i]) - 1);
                // 减到 0 就删除这个数字
                if (map.get(nums2[i]) == 0) {
                    map.remove(nums2[i]); 
                }
            }
        }
        // 最后遍历具有相同数字的 list 挨个放到 ans 数字中
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/solution/20200322350easy-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

