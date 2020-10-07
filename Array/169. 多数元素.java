#### [169. 多数元素](https://leetcode-cn.com/problems/majority-element/) + 巧用摩尔投票法

难度：Easy

### 解题思路

本题使用 **摩尔投票法**

其实质就是制定候选人，如果选上目标元素，则计数 `+ 1` ，否则 `- 1`

当计数为 `0` 的时候则更换候选人，不过我们知道，**众数的数量一定会大于其他所有元素之和**

也就是候选人票数一定会 `> 0`，所以当最后计数 `> 0` 时所选中的候选人即是目标元素

### 代码

```java
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        int candidate = 0;//记录目标元素
        for(int i = 0; i < n; i++){
            if(cnt == 0){//计数为0，则更换候选人
                candidate = nums[i];//将候选人更新为当前元素
            }
            //若候选人是当前元素，则计数+1，否则-1
            cnt += (candidate == nums[i]) ? 1 : -1;
        }
        return candidate;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/majority-element/solution/20200313mei-ri-yi-ti-easy-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



