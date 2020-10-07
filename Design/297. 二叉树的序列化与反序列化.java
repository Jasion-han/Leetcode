#### [297. 二叉树的序列化与反序列化](https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/) + sb，queue；String[]，queue

难度：Hard

### 解题思路

- 分别将 [树->字符串数组]，再 [字符串数组->树] 的过程

- 前者使用 `Stringuilder` + `Queue` 来 `BFS` 遍历树然后将节点放入字符串数组中
- 后者使用 `String[]` 先将字符串数组以 `“，”` 分割进行存储节点值，然后再用 `Queue` 构建树

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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            // 如果是 null 则放入 sb 中 null
            if (cur == null) {
                sb.append("null,");
            // 不是 null,就放入当前元素值和 ","
            } else {
                sb.append(cur.val + ",");
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }
        // 删除最后一个元素后面的 ","
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }
        // 将字符串以 "," 分割放入到字符串数组中
        String[] str = data.split(",");
        // 将 root 指向字符串数组第一个元素即 1
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        // 遍历除第一个元素以外后面的元素
        for (int i = 1; i < str.length; i++) {
            TreeNode cur = q.poll();
            // 如果不为 null 就左边放一个
            if (!str[i].equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(str[i]));
                q.offer(cur.left);
            }
            // 右边放一个(注意这里要将 i 提前移动一位,不然就是操作同一元素)
            if (!str[++i].equals("null")) {
                cur.right = new TreeNode(Integer.parseInt(str[i]));
                q.offer(cur.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

作者：Jasion_han
链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/solution/297-er-cha-shu-de-xu-lie-hua-yu-fan-xu-lie-hua-sbq/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

