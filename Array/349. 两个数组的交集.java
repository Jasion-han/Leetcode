#### [349. 两个数组的交集](https://leetcode-cn.com/problems/intersection-of-two-arrays/) + 巧用 HashSet

难度：Easy

### 解题思路

本题是典型的 使用 `Set` 查找存放 **非重复元素** 的容器

解法一用到了 `sort -> traversal -> set -> nlogn`
解法二用到了 `set1 -> set2 -> n`

故解法二时间复杂度要优于解法一

### 代码

解法一：

```java
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // 由于元素不能重复，故用 set 来存储
        Set<Integer> set = new HashSet<>();
        // 先对两数组排好序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // 定义两指针分别扫描两个数组
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        // 创建新的数组来存放满足条件的元素
        int[] ans = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            ans[k++] = num;
        }
        return ans;
    }
}
```

解法二：

```java
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        
        // 如果 set1 里有当前遍历到的元素,则放入 set2 中
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                set2.add(nums2[i]);
            }
        }
        
        // 创建新数组存放 set2 中的元素
        int[] ans = new int[set2.size()];
        int k = 0;
        for (Integer num : set2) {
            ans[k++] = num;
        }
        return ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/intersection-of-two-arrays/solution/20200322349easy-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

