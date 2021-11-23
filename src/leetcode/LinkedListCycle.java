package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LinkedListCycle {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        System.out.println(hasCycle(head));
        head.next = new ListNode(1);
        System.out.println(hasCycle(head));
        head.next.next = new ListNode(1);
        System.out.println(hasCycle(head));
        head.next.next = head;
        System.out.println(hasCycle(head));
    }
    public static boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == null) return false;
            if(fast==slow) return true;
        }
        return false;
    }

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }}

        public List<Integer> postorderTraversal(TreeNode root) {
            LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root != null) {
            stack.push(root);
            while(!stack.empty()){
                TreeNode node = stack.pop();
                result.addFirst(node.val);
                if(node.left != null) stack.push(node.left);
                if(node.right != null) stack.push(node.right);
            }
        }

        return result;
    }
}
