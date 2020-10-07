#### [204. 计数质数](https://leetcode-cn.com/problems/count-primes/) + boolean数组遍历筛选

难度：Easy

### 解题思路

- 本题需要注意的是使用 `boolean[]` 存储的默认元素为 `false`，为了正向操作，故先转换为 `true`

- 然后注意非质数的筛选方法，剩下的就是质数了

### 代码

解法一:

```java
class Solution {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        boolean[] primes = new boolean[n];
        // 也可以使用 Arrays.fill(primes, true);
        // 目的是使 primes 里面的元素为 true，因为默认是 false
        for (int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }
        
        // 排除非质数
        for (int i = 2; i * i < primes.length; i++) {
            if (primes[i]) {
                for (int j = i; j * i < primes.length; j++) {
                    primes[i * j] = false;
                }
            }
        }
        
        int cnt = 0;
        // 最后遍历为 true 的就是质数
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                cnt++;
            }
        }
        return cnt;
    }
}
```

解法二：

```java
public class Solution {
    /**
     * @param n: a integer
     * @return: return a integer
     */
    public int countPrimes(int n) {
        // write your code here
        if (n <= 1) {
            return 0;
        }
        
        int res = 0;
        boolean[] notPrime = new boolean[n];
        
        for (int i = 2; i < n; i++) {
            // “不是质数为 false ”也就是质数，故加入 res
            if (notPrime[i] == false) {
                res++;
                // 这里才是非质数的处理方法
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        
        return res;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/count-primes/solution/204-ji-shu-zhi-shu-booleanshu-zu-bian-li-shai-xuan/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

