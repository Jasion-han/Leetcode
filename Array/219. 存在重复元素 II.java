#### [219. 存在重复元素 II](https://leetcode-cn.com/problems/contains-duplicate-ii/) + 巧用 HashSet 的非重复性存储

难度：Easy

### 解题思路

本题充分利用了 `HashSet` 存储元素的不重复性

设置 `Set` 的大小保持里面 **最多** 有 `k` 个元素

如果当前访问的元素已经在 `Set` 中 **有记录**，则说明在 `k` 个大小以内存在重复元素返回 `true` 即可

通过遍历整个数组依次将 **非重复** 元素存入 `Set` 中

如果遍历到的元素个数超过了 `k`，则删除这 `k` 个区间内的 **第一个元素**

### 代码

```java
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        // 充分利用 Set 的不重复性存储不同的元素
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {  
            // 保持 Set 的大小在 k 以内发现相同元素
            if (set.contains(nums[i]) ) {
                return true;
            }
            set.add(nums[i]);
            // 若大小超过 k ，则删除这 k 个数的第一个元素
            if (set.size() > k) {
              set.remove(nums[i - k]);
            }
        }
        return false;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/contains-duplicate-ii/solution/20200327219easyha-xi-biao-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

