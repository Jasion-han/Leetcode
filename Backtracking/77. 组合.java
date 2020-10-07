#### [77. 组合](https://leetcode-cn.com/problems/combinations/) + 回溯法对数字组合

难度：Median

### 解题思路

本题是 `46` `47` 排序问题的下一个问题：组合

- 在 **组合 **数当中，按要求从前往后依次匹配 `k` 个元素，前面已经用过的元素就不能再参与后面的工作了
- 按照题目要求先将 **特殊情况 **给解决一下，然后调用 **回溯法 **依次进行组合
- 这里有一个优化的地方：`i <= n - (k - tmp.size()) + 1`; 代替了 `i < n`;，这样做使得剪枝可以方便的进行，减少后续冗余的操作，效率有着大幅提升。


- 其他操作就是回溯基本语句，遍历完之后返回 `ans` 即可。

### 代码

解法一：

```java
class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> combine(int n, int k) {        
        if (n <= 0 || k <= 0 || k > n) {
            return ans;
        }
        LinkedList<Integer> tmp = new LinkedList<>();
        // 回溯，这里题目要求从 1 开始，所以第三个参数为 1
        back(n, k, 1, tmp);
        return ans;
    }
    
    private void back(int n, int k, int index, LinkedList<Integer> tmp) {
        if (tmp.size() == k) {
            ans.add(new LinkedList<>(tmp));
            return;
        }
        // 还有 k - tmp.size() 个空位,所以[i...n]中至少要有 k - tmp.size() 个元素
        // i 最多为 n - (k - tmp.size()) + 1
        for (int i = index; i <= n - (k - tmp.size()) + 1; i++) {
            tmp.add(i);
            back(n, k, i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
```

解法二：

```java
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (n < 1 || k < 1 || k > n) {
            return ans;
        }
        List<Integer> tmp = new ArrayList<>();
        // 这里从 1 开始遍历
        backtrack(n, k, ans, tmp, 1);
        return ans;
    }
    
    private void backtrack(int n, int k, List<List<Integer>> ans, List<Integer> tmp, int index) {
        if (tmp.size() == k) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        // 优化,剪枝
        for (int i = index; i <= n - (k - tmp.size()) + 1; i++) {
            tmp.add(i);
            backtrack(n, k, ans, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/combinations/solution/2020041977medianhui-su-fa-dui-shu-zi-zu-he-by-jasi/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

