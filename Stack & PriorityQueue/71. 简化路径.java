#### [71. 简化路径](https://leetcode-cn.com/problems/simplify-path/) + 栈+字符数组+可变字符串容器

难度：Median

### 解题思路

本题使用了三种容器来求解绝对路径

首先定义栈用来存储 **路径信息**，定义字符数组 `str` 来 **分隔字符串**

依次遍历字符数组内容，这里使用 **增强型** `for` 循环，如果是 `“..”` 还要 **再判断是否为空** 才能弹出栈

如果不为空也不为 `“.”` 这说明当前元素是 **路径信息**，入栈即可

最后遍历完之后，先判断栈中 **是否有元素**，没有则返回 `“/”`

如果有元素，则使用 `StringBuilder` 来存放 **可变字符串**，最后返回 `ans` 即可。

### 代码

解法一：

```java
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        // 首先将字符串以 “/” 分隔存储到新的字符数组 str 中
        String[] str = path.split("/");
        for (String s : str) {
            // 如果访问到的是 “..” 则说明要返回上一级,要将当前元素出栈
            if (s.equals("..") ) {
                // 还需判断栈是否为空,否则会报错
                if (!stack.isEmpty() ) {
                    stack.pop();
                }                
            // 如果数组非空并且当前元素不是 “.” 说明当前元素是路径信息，要入栈
            } else if (!s.equals("") && !s.equals(".")) {
                stack.push(s);
            }
        }
        // 如果栈内没有元素说明没有路径信息，返回 “/” 即可
        if (stack.isEmpty()) {
            return "/";
        }
        // 这里用到 StringBuilder 操作字符串，效率高
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            // 这里从栈底开始拿元素
            ans.append( "/" + stack.get(i) );
        }
        return ans.toString();
    }
}
```

解法二：

```java
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        // 以 / 分割路径并存储到 str 字符串数组中
        String[] str = path.split("/");
        
        for (int i = 0; i < str.length; i++) {
            // 除去每个字符串两边的空格
            String cur = str[i].trim();
            if (cur == null || cur.length() == 0 || cur.equals(".")) {
                continue;
            }
            if (cur.equals("..")) {
                // 必须要判断栈是否为空
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(cur);
            }
        }
        
        String ans = "";
        // 巧妙的反向构建结果
        while (!stack.isEmpty()) {
            ans = "/" + stack.pop() + ans;
        }
        // 最后还要判断是否为空
        return ans.length() == 0 ? "/" : ans;
    }
}

作者：Jasion_han
链接：https://leetcode-cn.com/problems/simplify-path/solution/2020040371medianzhan-zi-fu-shu-zu-ke-bian-zi-fu-ch/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

