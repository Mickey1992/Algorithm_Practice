package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SymmetricTree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(2));
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetricStack(root));
        System.out.println(isSymmetricRecursion(root));
    }
    public static boolean isSymmetricStack(TreeNode root){
        if(root == null) return false;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        stack2.push(root);
        while(!(stack1.empty() && stack2.empty())){
            TreeNode node1 = stack1.pop();
            TreeNode node2 = stack2.pop();
            if(node1 == null && node2 == null){
                continue;
            }else if (node1 != null && node2 != null && node1.val == node2.val){
                stack1.push(node1.right);
                stack1.push(node1.left);
                stack2.push(node2.left);
                stack2.push(node2.right);
            }else{
                return false;
            }
        }
        return true;
    }
    public static boolean isSymmetricStack2(TreeNode root) {
        if(root == null) return false;
        Queue<TreeNode> nextLevel = new LinkedList<>();
        int nextLevelCnt = 2;
        nextLevel.add(root.left);
        nextLevel.add(root.right);
        while(nextLevelCnt > 0){
            int curLevelCnt = nextLevelCnt;
            int halfCnt = curLevelCnt/2;
            nextLevelCnt = 0;
            Stack<TreeNode> chk = new Stack<>();
            do{
                TreeNode curNode = nextLevel.remove();
                if(curLevelCnt <= halfCnt){
                    TreeNode compare = chk.pop();
                    if(!((compare == null && curNode == null)
                            || (compare != null && curNode != null && compare.val == curNode.val)
                    )) return false;
                }else{
                    chk.push(curNode);
                }

                if(curNode != null){
                    nextLevel.add(curNode.left);
                    nextLevel.add(curNode.right);
                    nextLevelCnt += 2;
                }
            }while(--curLevelCnt > 0);
        }
        return true;
    }


    public static boolean isSymmetricRecursion(TreeNode root) {
        if(root == null) return false;
        return isSymmetric(root.left, root.right);
    }

    public static boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) return true;
        if(node1 != null && node2 != null){
            return (node1.val == node2.val) && isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
        }
        return false;
    }

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
