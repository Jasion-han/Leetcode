#### [445. 两数相加 II](https://leetcode-cn.com/problems/add-two-numbers-ii/) + 用栈来逆序处理两数之和

难度：Median

### 解题思路

本题利用 **两个栈** 来存储两个链表的元素，定义 **两栈元素和**  `sum` 和 **进位标志**  `flag`

- 每次将 **链头元素入栈**，栈中每次取出的就是 **链尾元素**
- 用 `sum` 记录两栈尾元素之和，创建新链表表头结点 `head` **准备链接新生成的结点** 元素
- 创建新链结点 `node` 存储 **对10取余** 后的元素，用 `flag` 记录 **除以10得到的进位值**  `0` 或 `1`
- 每次让新生成的 `node` 指向 `head`，然后 `head` **逆序** 链接到新链表头，最后返回 `head` 就是一条新链。

### 代码

解法一：

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 定义两个栈存储两个链表的元素
        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();
        
        // 定义 node1 指针遍历 l1 链表元素入栈
        ListNode node1 = l1;
        while (node1 != null) {
            stack1.push(node1.val);
            node1 = node1.next;
        }
        
        // 定义 node2 指针遍历 l2 链表元素入栈
        ListNode node2 = l2;
        while (node2 != null) {
            stack2.push(node2.val);
            node2 = node2.next;
        }
        
        // 创建新链表头结点 head
        ListNode head = null;
        // 定义进位标志 0 / 1
        int flag = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || flag != 0) {
            // 定义累加和
            int sum = 0;
            // 每次判断将栈 1 和栈 2 的元素依次弹出并用累加和 sum 记录
            if (!stack1.isEmpty() ) {
                sum += stack1.pop();
            }
            if (!stack2.isEmpty() ) {
                sum += stack2.pop();
            }
            // 如果有进位则加上进位值 0 / 1
            sum += flag;
            // 创建 node 指向累加和计算出来的元素
            ListNode node = new ListNode(sum % 10);
            // 求出进位值 0 / 1
            flag = sum / 10;
            // 每次将 node 指向 head，然后 head 反方向移动，最后则处于链表头部
            node.next = head;
            head = node;
        }
        return head;
    }
}
```

解法二：

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) { 
        // 用 stack 保存链表，再从 stack 中取出来，就是数字从低位到高位访问了
        // Tips: 逆序处理，一般都会用到栈
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        
        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int sum = carry;
            sum += stack1.isEmpty()? 0: stack1.pop();
            sum += stack2.isEmpty()? 0: stack2.pop();
            ListNode node = new ListNode(sum % 10);
            // 每次将 node 指向 head，然后 head 反方向移动，最后则处于链表头部
            node.next = head;
            head = node;
            carry = sum / 10;
        }
        return head;
    }
}


作者：Jasion_han
链接：https://leetcode-cn.com/problems/add-two-numbers-ii/solution/20200329445median-by-jasion_han-r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

