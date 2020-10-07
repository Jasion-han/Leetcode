#### [216. 组合总和 III](https://leetcode-cn.com/problems/combination-sum-iii/) + 回溯法寻找和为n的k个数的组合

难度：Median

### 解题思路

本题也是 `39` `40` 两题的改编版，不过这道题比前两题稍微简单点

- 这里给出了 `k` 个数，和为 `n`,首先 **判空**
- 然后还是利用 **回溯法 **进行遍历，循环体内变成了从 `index = 1` 开始一直到 `9` 结束
- 需要注意的是 **下次递归的参数**，个数需要减 `1`，总和需要减去当前的值 `i`，下次需要从 `i` 的后一个元素开始遍历
- 遍历完放入 `ans` 返回即可。

### 代码

解法一：

```java
class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k == 0 || n > k * 9) {
            return ans;
        }
        List<Integer> tmp = new ArrayList<>();
        // 回溯
        back(k, n, 1, tmp);
        return ans;
    }
    
    private void back(int k, int n, int index, List<Integer> tmp) {
        if (k == 0 && n == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        
        // 这里从 index 代表的 1 开始遍历到 9
        for (int i = index; i < 10; i++) {
            if (i <= n) {
                tmp.add(i);
                // 下一轮开始个数减 1，和也减少 i，从 i 的后一个元素开始遍历
                back(k - 1, n - i, i + 1, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
```

解法二：

```java
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        if (k < 1 || n < 1 || n > k * 9) {
            return ans;
        }
        List<Integer> tmp = new ArrayList<>();
        backtrack(k, n, ans, tmp, 1);
        return ans;
    }
    
    private void backtrack(int k, int n, List<List<Integer>> ans, List<Integer> tmp, int index) {
        if (k == 0 && n == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        
        // 优化:提前判断 k 如果已经满足个数,后面的 for 循环就不用执行了
        if (k == 0) {
            return;
        }
        
        for (int i = index; i <= 9; i++) {
            tmp.add(i);
            // 注意这里每回溯一次,k 要减去一个位置,n 要减去当前的值,i 要从下一个位置开始遍历
            backtrack(k - 1, n - i, ans, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/combination-sum-iii/solution/20200420216medianhui-su-fa-xun-zhao-he-wei-nde-kge/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

