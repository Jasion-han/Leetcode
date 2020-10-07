#### [307. 区域和检索 - 数组可修改](https://leetcode-cn.com/problems/range-sum-query-mutable/) + 数组可修改 + 线段树，动态规划双解法

难度：Median

### 解题思路

本题使用双解法
对于解法一使用 **线段树** 来进行更少时间复杂度的计算
对于解法二使用 **动态规划** 的思想也是更快的解决问题

### 代码

解法一：

```java
class NumArray {
    
    // 创建线段树结构体
    class SegmentTreeNode {
        SegmentTreeNode left;
        SegmentTreeNode right;
        int start;
        int end;
        int sum;
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            left = null;
            right = null;
        }
    }
    
    // 创建根节点
    SegmentTreeNode root = null;
    
    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }
    
    // 创建建树的方法
    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        SegmentTreeNode ans = new SegmentTreeNode(start, end);
        // 如果只有一个元素，则取出 start 即可
        if (start == end) {
            ans.sum = nums[start];
        } else {
            // 如果有多个，就用二分将左右子树连接起来
            int mid = start + (end - start) / 2;
            ans.left = buildTree(nums, start, mid);
            ans.right = buildTree(nums, mid + 1, end);
            // 计算总和
            ans.sum = ans.left.sum + ans.right.sum;
        }
        return ans;
    }
    
    public void update(int i, int val) {
        update(root, i, val);
    }
    
    // 创建更新节点值的方法
    private void update(SegmentTreeNode root, int i, int val) {
        // 如果只有一个节点
        if (root.start == root.end) {
            root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            // 如果更新值在左半部分
            if (i <= mid) {
                update(root.left, i, val);
            // 如果更新值在右半部分
            } else {
                update(root.right, i, val);
            }
            // 更新总和
            root.sum = root.left.sum + root.right.sum;
        }
    }
    
    public int sumRange(int i, int j) {
        return query(root, i, j);
    }
    
    // 创建查询数组范围的方法
    private int query(SegmentTreeNode root, int i, int j) {
        // 如果查询的是全长，则直接返回总和即可
        if (root.start == i && root.end == j) {
            return root.sum;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            // 范围在左边
            if (j <= mid) {
                return query(root.left, i, j);
            // 范围在右边
            } else if (i >= mid + 1) {
                return query(root.right, i, j);
            // 范围包括左右两边
            } else {
                return query(root.left, i, mid) + query(root.right, mid + 1, j);
            }
        }
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
```



解法二：

```java
class NumArray {

    int[] nums;
    int[] tree;
    int n;

    // time : O(n * logn)
    public NumArray(int[] nums) {
        n = nums.length;
        // 动态规划思想(存储的是下标从 0 到 i 所有元素的和)
        tree = new int[n + 1];
        this.nums = new int[n];
        for (int i = 0; i < n; i++) {
            update(i, nums[i]);
        }
    }

    // time : O(logn)
    public void update(int i, int val) {
        if (n == 0) {
            return;
        }
        // 更新的差值
        int diff = val - nums[i];
        // 先更新为新的值
        nums[i] = val;
        // 更新新的数组 tree 下标 i 之后的总和
        for (int j = i + 1; j <= n; j += j & (-j)) {
            tree[j] += diff;
        }
    }

    // time : O(logn)
    public int sumRange(int i, int j) {
        // 用下标为 j + 1 的总和减去下标为 i 的总和 
        return sum(j + 1) - sum(i);
    }

    // 创建求前 i 个元素之和的方法
    private int sum(int k) {
        int sum = 0;
        for (int i = k; i > 0; i -= i & (-i)) {
            sum += tree[i];
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */

作者：Jasion_han
链接：https://leetcode-cn.com/problems/range-sum-query-mutable/solution/307-qu-yu-he-jian-suo-shu-zu-ke-xiu-gai-xian-dua-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

