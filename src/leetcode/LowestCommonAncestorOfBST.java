package leetcode;

public class LowestCommonAncestorOfBST {
    public TreeNode lowestCommonAncestorRecursion(TreeNode root, TreeNode p, TreeNode q) {
        if(Math.min(p.val, q.val) > root.val) return lowestCommonAncestorRecursion(root.right, p, q);
        if(Math.max(p.val, q.val) < root.val) return lowestCommonAncestorRecursion(root.left, p, q);
        return root;
    }

    public TreeNode lowestCommonAncestorIteration(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        int min = Math.min(p.val, q.val) ;
        int max = Math.max(p.val, q.val) ;
        while(node != null){
            if(min > node.val){
                node = node.right;
            }else if(max < root.val){
                node = node.left;
            }else{
                break;
            }
        }
        return node;
    }


}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
