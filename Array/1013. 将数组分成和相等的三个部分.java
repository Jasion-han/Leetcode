#### [1013. 将数组分成和相等的三个部分](https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/) + 头尾双指针法

难度：Easy

### 解题思路

本题击败双100%用户

首先将整个数组的数组加起来看能不能除尽 `3`，若不能则无法分组，若能则继续

使用双指针法分别在数组头和数组尾设立两个索引

头索引依次 + 后面的元素，直到满足三等分的第一组

同时，尾索引依次 + 前面的元素，直到满足三等分的第一组

第一组和第三组都划分好后，那么中间第二组也满足要求，这样就分好 `3` 组了。

### 代码

```java
class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        
        for(int i:A){
            sum += i;
        }
        
        if(sum % 3 != 0){//整个数组加起来不能除尽3，则无法3等分
            return false;
        }
        
        int left = 0;
        int leftSum = A[left];//代表第一组
        int right = A.length - 1;
        int rightSum = A[right];//直接代表整个数组
        
        while(left + 1 < right){//中间可以留出一组
            if(leftSum == sum / 3 && rightSum == sum / 3){
                return true;
            }
            if(leftSum != sum / 3){//左边不满足就不断++，直到满足第一组等分
                leftSum += A[++left];
            }
            if(rightSum != sum / 3){
                rightSum += A[--right];
            }
        }
        return false;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/solution/20200311mei-ri-yi-ti-easy-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



