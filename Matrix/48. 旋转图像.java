#### [48. 旋转图像](https://leetcode-cn.com/problems/rotate-image/) + 上下，两侧互换法

难度：Median

### 解题思路

本题利用矩阵 **上下，对角线两侧互换** 得到结果，类似题目都可以使用该做法。

### 代码

```java
class Solution {
    public void rotate(int[][] matrix) {
        // 定义矩阵的最上面一行和最下面一行
        int top = 0;
        int down = matrix.length - 1;
        while (top < down) {
            // 上下两行交换
            int[] tmp = matrix[top];
            matrix[top] = matrix[down];
            matrix[down] = tmp;
            top++;
            down--;
        }
        
        // 对角线一侧元素互换即可,比如交换 2, 3, 6
        for (int i = 0; i < matrix.length; i++) {
            // 只交换对角线以上或以下一侧的元素即可
            for (int j = i + 1; j < matrix[i].length; j++){
                // 对角线左右两侧元素互换
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/rotate-image/solution/48-xuan-zhuan-tu-xiang-shang-xia-liang-ce-hu-huan-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

