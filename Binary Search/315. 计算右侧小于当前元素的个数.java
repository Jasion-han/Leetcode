#### [315. 计算右侧小于当前元素的个数](https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/) + 二分，归并

难度：Hard

### 解题思路

本题主要就是 **归并**，设置 **左右双指针** 进行比较之后使用 **归并排序** 再输出

### 代码

```java
class Solution {
    
    // 创建 Item 结构体记录元素的值和索引
    class Item {
        int val;
        int index;
        public Item(int v, int i) {
            val = v;
            index = i;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Item[] items = new Item[n];
        // 将 nums 里面所有数字以及索引都放到 items 里
        for (int i = 0; i < n; i++) {
            items[i] = new Item(nums[i], i);
        }
        // 记录右侧小于 nums[i] 的元素的数量
        int[] count = new int[n];
        
        mergeSort(items, 0, n - 1, count);
        
        // 把 count 中的值放入 list 返回
        List<Integer> ans = new ArrayList<>();
        for (int c : count) {
            ans.add(c);
        }
        return ans;
    }
    
    // 归并排序
    private void mergeSort(Item[] items, int left, int right, int[] count) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(items, left, mid, count);
        mergeSort(items, mid + 1, right, count);
        merge(items, left, mid, mid + 1, right, count);
    }
    
    // 合并
    private void merge(Item[] items, int left, int leftEnd, int right, int rightEnd, int[] count) {
        int len = rightEnd - left + 1;
        Item[] sorted = new Item[len];
        // 定义左右两指针分别从两段的头部开始遍历
        int leftP = left;
        int rightP = right;
        // 记录右边比当前数字小的个数
        int rightCounter = 0;
        
        int index = 0;
        while (leftP <= leftEnd && rightP <= rightEnd) {
            // round1: left 5,      right 2
            // round2: left 6,      right 1
            // round3: left 2, 5,   right 1, 6
            if (items[rightP].val < items[leftP].val) {
                rightCounter++;
                sorted[index++] = items[rightP++];
            } else {
                count[items[leftP].index] += rightCounter;
                sorted[index++] = items[leftP++];
            }
        }
        while (leftP <= leftEnd) {
            count[items[leftP].index] += rightCounter;
            sorted[index++] = items[leftP++];
        }
        while (rightP <= rightEnd) {
            sorted[index++] = items[rightP++];
        }
        // 最后将 sorted 里面的复制到 items 里面
        System.arraycopy(sorted, 0, items, left, len);
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/solution/315-ji-suan-you-ce-xiao-yu-dang-qian-yuan-su-de-16/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

