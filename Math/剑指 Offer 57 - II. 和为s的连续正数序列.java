#### [剑指 Offer 57 - II. 和为s的连续正数序列](https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/) + 等差数列求和公式的使用

难度：Easy

### 解题思路

本题能想到的第一个方法就是 **窗口滑动** ，基本适用于该类问题，也适用于非排序问题，但效率可能不高？

这里使用的是 **数学方法**，利用等差数列求和公式求解会更高效点，但是需要具备数学思维的底子。

### 代码

```java
class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res=new ArrayList<>();
        int l=1;
        int r=2;
        while(l<r){
            int sum=(l+r)*(r-l+1)/2;//等差数列求和公式
            if(sum<target){
                r++;
            }else if(sum>target){
                l++;
            }else{
                int[] arr=new int[r-l+1];
                for(int i=l; i < r+1; i++){//从所选区间依次放入数组中
                    arr[i-l]=i;   
                }
                res.add(arr);//将数组添加至容器
                l++;
                r++;
            }
        }
        return res.toArray(new int[0][]);//据说是非算法层面的优化？
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/20200306mei-ri-yi-ti-easy-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



