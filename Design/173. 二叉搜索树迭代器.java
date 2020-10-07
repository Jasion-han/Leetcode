#### [173. 二叉搜索树迭代器](https://leetcode-cn.com/problems/binary-search-tree-iterator/) + 栈不断寻找左边元素而后右边元素

难度：Median

### 解题思路

用到两个全局变量来定义当前所指元素以及栈，不断寻找左边元素求出最小值，然后再去看右边。

### 代码

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {

    private TreeNode cur;
    private Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        cur = root;
        stack = new Stack<>();
    }
    
    /** @return the next smallest number */
    public int next() {
        while (cur != null) {
            stack.push(cur);
            // 不断找左边元素，最后栈顶的就是最小的
            cur = cur.left;
        }
        // 此时弹出的是剩余里面最小的
        cur = stack.pop();
        // 取到当前的值
        int val = cur.val;
        cur = cur.right;
        return val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        // 如果有一方为 null 说明还有剩余元素
        if (!stack.isEmpty() || cur != null) {
            return true;
        // 都为 null 则没有剩余元素
        } else {
            return false;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

作者：Jasion_han
链接：https://leetcode-cn.com/problems/binary-search-tree-iterator/solution/173-er-cha-sou-suo-shu-die-dai-qi-zhan-bu-duan-xun/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

