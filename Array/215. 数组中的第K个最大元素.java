#### [215. 数组中的第K个最大元素](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/) + quick select 法

难度：Median

### 解题思路

本题最优解法应该是用 `quick select`,具体解法看代码注释。

### 代码

解法一：

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // pq 默认存放的是较大数,如果有更大的数加进来会将原有较小的出队
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            // 当 k = 2 时,若 pq 里面有三个元素,那么出队的默认是较小者
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}
```

解法二：

```java
class Solution {
    private static Random random = new Random(System.currentTimeMillis());

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        // 转换一下，第 k 大元素的索引是 len - k
        int target = len - k;

        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    public int partition(int[] nums, int left, int right) {//分治思想没看懂？？？
        // 在区间随机选择一个元素作为标定点
        if (right > left) {
            int randomIndex = left + random.nextInt(right - left + 1);
            swap(nums, left, randomIndex);
        }

        int pivot = nums[left];

        // 将等于 pivot 的元素分散到两边
        // [left, lt) <= pivot
        // (rt, right] >= pivot

        int lt = left + 1;
        int rt = right;

        while (true) {
            while (lt <= rt && nums[lt] < pivot) {
                lt++;
            }
            while (lt <= rt && nums[rt] > pivot) {
                rt--;
            }

            if (lt > rt) {
                break;
            }
            swap(nums, lt, rt);
            lt++;
            rt--;
        }
        swap(nums, left, rt);
        return rt;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
```

解法三：

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // quick select 法
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int pos = position(nums, left, right);
            // 因为从左往右是从大到小排列
            // 所以第一大的下标 pos 是 0,第二大的下标 pos 是 1,故需要 pos + 1 来判断是第几大
            if (pos + 1 == k) {
                return nums[pos];
            } else if (pos + 1 > k) {
                right = pos - 1;
            } else {
                left = pos + 1;
            }
        }
    }
    
    private int position(int[] nums, int left, int right) {
        
        // 最左边为基准(也可随机)
        int pivot = nums[left];
        int l = left + 1;
        int r = right;
        // [3,2,1,5,6,4]
        // [3,4,1,5,6,2]
        // [3,4,6,5,1,2]
        // [5,4,6,3,1,2]
        while (l <= r) {
            // 交换两位置上的数值(l, r位置不变,只改变值)
            // 最终使得比 pivot 大的数在左边,小的在右边
            if (nums[l] <= pivot && nums[r] > pivot) {
                swap(nums, l, r);
                l++;
                r--;
            }
            if (nums[l] >= pivot) {
                l++;
            }
            if (nums[r] <= pivot) {
                r--;
            }
        }
        // 交换第一个元素和当前 r 所指元素的值,位置不变
        swap(nums, left, r);
        return r;
    }
    
    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/20200319215median-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

