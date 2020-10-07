#### [121. 买卖股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/) + 贪心法买卖股票

难度：Easy

### 解题思路

本题使用 **贪心算法** 买卖股票，思想就是 **以最低的价格买入，以最高的价格售出！**

定义一个 `min` 用来记录股票的最小值。通过遍历数组，如果之后有一天比之前买入价格更低，则将最低购买价格赋值给 `min`

定义一个 `max` 用来记录股票售出和买入之间的最大差额，即用当前价格减去最小值所得的差值。

每当遇到更高的价格就用他减去最小值并与之前的最大差值进行比较，差额最大的即为所求最大利润。

### 代码

```java
class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        int n = prices.length;
        for(int i = 0 ; i < n ; i++){
            if(prices[i] < min){//遍历完整个数组就会选出最小值
                min = prices[i];
            }else if(prices[i] - min > max){//依次比较，选出最大差值
                max = prices[i] - min;
            }
        }
        return max;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/20200314121easy-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



